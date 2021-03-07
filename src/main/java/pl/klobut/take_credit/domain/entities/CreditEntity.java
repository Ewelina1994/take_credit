package pl.klobut.take_credit.domain.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "credits")
public class CreditEntity implements Serializable {
    //  private static int creditIdCounter = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String creditName;
    @ManyToMany()
    @JoinTable(
            name = "credit_customer",
            joinColumns = @JoinColumn(name = "credit_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<CustomerEntity> customers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "credit")
    private List<ProductEntity> products = new ArrayList<>();
    @ManyToOne
    private CreditProductEntiti creditProduct;
    private Long value;
    private Long allValue;
    private int monthsOfReplayment;
    @ManyToOne
    private TypesReplaymentEntiti typesReplayment;
    private Date creatingDate;
    private Date lastRateDate;
    private int valueNestRate;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "creditEntity")
    private List<RepaymentsEntiti> repaymentsEntitis = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public List<CustomerEntity> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerEntity> customers) {
        this.customers = customers;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public CreditProductEntiti getCreditProduct() {
        return creditProduct;
    }

    public void setCreditProduct(CreditProductEntiti creditProduct) {
        this.creditProduct = creditProduct;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getAllValue() {
        return allValue;
    }

    public void setAllValue(Long allValue) {
        this.allValue = allValue;
    }

    public int getMonthsOfReplayment() {
        return monthsOfReplayment;
    }

    public void setMonthsOfReplayment(int monthsOfReplayment) {
        this.monthsOfReplayment = monthsOfReplayment;
    }

    public TypesReplaymentEntiti getTypesReplayment() {
        return typesReplayment;
    }

    public void setTypesReplayment(TypesReplaymentEntiti typesReplayment) {
        this.typesReplayment = typesReplayment;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Date getLastRateDate() {
        return lastRateDate;
    }

    public void setLastRateDate(Date lastRateDate) {
        this.lastRateDate = lastRateDate;
    }

    public int getValueNestRate() {
        return valueNestRate;
    }

    public void setValueNestRate(int valueNestRate) {
        this.valueNestRate = valueNestRate;
    }

    public List<RepaymentsEntiti> getRepaymentsEntitis() {
        return repaymentsEntitis;
    }

    public void setRepaymentsEntitis(List<RepaymentsEntiti> repaymentsEntitis) {
        this.repaymentsEntitis = repaymentsEntitis;
    }
}
