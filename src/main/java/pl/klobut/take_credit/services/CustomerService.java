package pl.klobut.take_credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.klobut.take_credit.entiti.Customer;
import pl.klobut.take_credit.repository.CustomerRepo;

import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Optional<Customer> getCustomersByCreditId(Long creditId) {
        return customerRepo.findAllByCreditId(creditId);
    }

    public Customer addNewCustomer(Customer customer){
        return customerRepo.save(customer);
    }
}
