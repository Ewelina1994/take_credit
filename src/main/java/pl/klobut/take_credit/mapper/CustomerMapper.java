package pl.klobut.take_credit.mapper;

import org.springframework.stereotype.Component;
import pl.klobut.take_credit.domain.entities.CustomerEntity;
import pl.klobut.take_credit.domain.models.Customer;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements EntityMapper<Customer, CustomerEntity> {

    @Override
    public CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setFirstname(customer.getFirstname());
        customerEntity.setSurname(customer.getSurname());
        customerEntity.setPesel(customer.getPesel());
        return customerEntity;
    }

    @Override
    public Customer toDto(CustomerEntity customerEntity) {
        Customer customer=new Customer();
        customer.setFirstname(customerEntity.getFirstname());
        customer.setSurname(customerEntity.getSurname());
        customer.setPesel(customerEntity.getPesel());
        return customer;
    }

    @Override
    public List<CustomerEntity> toEntityList(List<Customer> customers) {
        List<CustomerEntity> customerEntityList=new ArrayList<>();
        customers.forEach(c->{
            customerEntityList.add(toEntity(c));
        });
        return customerEntityList;
    }

    @Override
    public List<Customer> toDtoList(List<CustomerEntity> customerEntities) {
        List<Customer> customerList= new ArrayList<>();
        customerEntities.forEach(c->{
            customerList.add(toDto(c));
        });
        return customerList;
    }
}
