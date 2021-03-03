package pl.klobut.take_credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klobut.take_credit.entiti.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    public Optional<Customer> findAllByCreditId(Long id);
}
