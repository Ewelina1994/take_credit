package pl.klobut.take_credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.klobut.take_credit.entiti.Credit;
import pl.klobut.take_credit.repository.CreditRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {
    private CreditRepo creditRepo;

    @Autowired
    public CreditService(CreditRepo creditRepo) {
        this.creditRepo = creditRepo;
    }

    public Optional<Credit> getCreditById(Long idCredit) {
        return creditRepo.findById(idCredit);
    }

    public Page<Credit> getAllCredits(Pageable pageable){
        return creditRepo.findAll(pageable);
    }

    public Credit addNewCredit (Credit credit) {
        return creditRepo.save(credit);
    }

}
