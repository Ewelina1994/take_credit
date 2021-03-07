package pl.klobut.take_credit.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RepaymentsEntiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "credit_id")
    private CreditEntity creditEntity;
    private float valueRepayment;
    private Date currentDate;

    public RepaymentsEntiti() {
    }

    public RepaymentsEntiti(CreditEntity creditEntity, float valueRepayment, Date currentDate) {
        this.creditEntity = creditEntity;
        this.valueRepayment = valueRepayment;
        this.currentDate = currentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditEntity getCreditEntity() {
        return creditEntity;
    }

    public void setCreditEntity(CreditEntity creditEntity) {
        this.creditEntity = creditEntity;
    }

    public float getValueRepayment() {
        return valueRepayment;
    }

    public void setValueRepayment(float valueRepayment) {
        this.valueRepayment = valueRepayment;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
