package pl.klobut.take_credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klobut.take_credit.domain.entities.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findAllByCreditId(Long id);
}
