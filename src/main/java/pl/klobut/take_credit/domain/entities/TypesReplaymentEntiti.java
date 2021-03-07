package pl.klobut.take_credit.domain.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.klobut.take_credit.domain.enums.RateTypes;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypesReplaymentEntiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private RateTypes rateTypes;
    @OneToMany(mappedBy = "typesReplayment", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CreditEntity> creditEntityList;

    public TypesReplaymentEntiti() {
    }

    public TypesReplaymentEntiti(RateTypes rateTypes, List<CreditEntity> creditEntityList) {
        this.rateTypes = rateTypes;
        this.creditEntityList = creditEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RateTypes getRateTypes() {
        return rateTypes;
    }

    public void setRateTypes(RateTypes rateTypes) {
        this.rateTypes = rateTypes;
    }

    public List<CreditEntity> getCreditEntityList() {
        return creditEntityList;
    }

    public void setCreditEntityList(List<CreditEntity> creditEntityList) {
        this.creditEntityList = creditEntityList;
    }
}
