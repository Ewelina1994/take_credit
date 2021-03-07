package pl.klobut.take_credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.klobut.take_credit.domain.entities.CreditEntity;
import pl.klobut.take_credit.domain.entities.CustomerEntity;
import pl.klobut.take_credit.domain.models.Customer;
import pl.klobut.take_credit.exceptions.ResourceNotFoundException;
import pl.klobut.take_credit.mapper.CustomerMapper;
import pl.klobut.take_credit.repository.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    public List<Customer> getCustomersByCreditId(Long creditId) {
        List<CustomerEntity> allByCreditId = customerRepo.findAllByCreditId(creditId);
        if(allByCreditId.isEmpty()){
            new ResourceNotFoundException("Custorm with credit id: " + creditId + " not found");
        }
        List<Customer> customerList=customerMapper.toDtoList(allByCreditId);
        return customerList;
    }

    public List<CustomerEntity> addNewCustomers(List<Customer> customers, List<CreditEntity> creditId) {
        List<CustomerEntity> customerEntityList = new ArrayList<>();
        customers.stream().forEach(customer -> {
            CustomerEntity entiti = customerMapper.toEntity(customer);
            entiti.setCreditId(creditId);
            customerEntityList.add(entiti);
        });
        return customerRepo.saveAll(customerEntityList);
    }
}
