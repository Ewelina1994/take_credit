package pl.klobut.take_credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klobut.take_credit.domain.entities.CreditEntity;

@Repository
public interface CreditRepo extends JpaRepository<CreditEntity, Long> {
}
