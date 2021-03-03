package pl.klobut.take_credit.mapper;

import org.springframework.stereotype.Component;
import pl.klobut.take_credit.domain.entities.CreditEntity;
import pl.klobut.take_credit.domain.models.Credit;

import java.util.List;

@Component
public class CreditMapper implements EntityMapper<Credit, CreditEntity> {
    @Override
    public CreditEntity toEntity(Credit credit) {
        CreditEntity creditEntity= new CreditEntity();
        creditEntity.setCreditName(credit.getCreditName());
        return creditEntity;
    }

    @Override
    public Credit toDto(CreditEntity creditEntity) {
        Credit credit= new Credit();
        credit.setCreditName(creditEntity.getCreditName());
        return credit;
    }

    @Override
    public List<CreditEntity> toEntityList(List<Credit> credits) {
        return null;
    }

    @Override
    public List<Credit> toDtoList(List<CreditEntity> creditEntities) {
        return null;
    }
}
