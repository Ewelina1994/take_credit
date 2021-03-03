package pl.klobut.take_credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klobut.take_credit.entiti.Product;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    public Optional<Product> findAllByCreditId(Long id);
}
