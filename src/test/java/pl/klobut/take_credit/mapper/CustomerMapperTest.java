package pl.klobut.take_credit.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.klobut.take_credit.domain.entities.CustomerEntity;
import pl.klobut.take_credit.domain.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {
    CustomerMapper customerMapper;

    @BeforeEach
    void setUp() {
        customerMapper = new CustomerMapper();
    }

    @Test
    void toEntity() {
        Customer customer = new Customer();
        customer.setFirstname("Iga");
        customer.setSurname("Swiątek");
        customer.setPesel("97021512100");

        CustomerEntity customerEntity = customerMapper.toEntity(customer);

        assertEquals(customerEntity.getFirstname(), customer.getFirstname());
        assertEquals(customerEntity.getSurname(), customer.getSurname());
        assertEquals(customerEntity.getPesel(), customer.getPesel());
    }

    @Test
    void toDto() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstname("Rafał");
        customerEntity.setSurname("Majka");
        customerEntity.setPesel("88120255400");

        Customer customer = customerMapper.toDto(customerEntity);

        assertEquals(customerEntity.getFirstname(), customer.getFirstname());
        assertEquals(customerEntity.getSurname(), customer.getSurname());
        assertEquals(customerEntity.getPesel(), customer.getPesel());
    }

    @Test
    void toEntityList() {
    }

    @Test
    void toDtoList() {
    }
}
