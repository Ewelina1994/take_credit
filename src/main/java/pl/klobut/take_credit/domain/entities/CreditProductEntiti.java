package pl.klobut.take_credit.domain.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class CreditProductEntiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCredit;
    private int minValueKredit;
    private int maxValueCredit;
    private int maximumRepaymentTimeMonth;
    private float annualInterestRate;
    private float commission;
    @OneToMany(mappedBy = "creditProduct", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CreditEntity> creditEntityList;

    public CreditProductEntiti() {
    }

    public CreditProductEntiti(String nameCredit, int minValueKredit, int maxValueCredit, int maximumRepaymentTimeMonth, float annualInterestRate, float commission, List<CreditEntity> creditEntityList) {
        this.nameCredit = nameCredit;
        this.minValueKredit = minValueKredit;
        this.maxValueCredit = maxValueCredit;
        this.maximumRepaymentTimeMonth = maximumRepaymentTimeMonth;
        this.annualInterestRate = annualInterestRate;
        this.commission = commission;
        this.creditEntityList = creditEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCredit() {
        return nameCredit;
    }

    public void setNameCredit(String nameCredit) {
        this.nameCredit = nameCredit;
    }

    public int getMinValueKredit() {
        return minValueKredit;
    }

    public void setMinValueKredit(int minValueKredit) {
        this.minValueKredit = minValueKredit;
    }

    public int getMaxValueCredit() {
        return maxValueCredit;
    }

    public void setMaxValueCredit(int maxValueCredit) {
        this.maxValueCredit = maxValueCredit;
    }

    public int getMaximumRepaymentTimeMonth() {
        return maximumRepaymentTimeMonth;
    }

    public void setMaximumRepaymentTimeMonth(int maximumRepaymentTimeMonth) {
        this.maximumRepaymentTimeMonth = maximumRepaymentTimeMonth;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public List<CreditEntity> getCreditEntityList() {
        return creditEntityList;
    }

    public void setCreditEntityList(List<CreditEntity> creditEntityList) {
        this.creditEntityList = creditEntityList;
    }
}
