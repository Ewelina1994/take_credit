package pl.klobut.take_credit.entiti;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id", nullable = false, referencedColumnName="id")
    private Credit creditId;
    @NotNull
    @Column(unique = true)
    private String productName;
    @NotNull
    private int value;

    public Product() {
    }

    public Product(Credit creditId, String productName, int value) {
        this.creditId = creditId;
        this.productName = productName;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Credit getCreditId() {
        return creditId;
    }

    public void setCreditId(Credit creditId) {
        this.creditId = creditId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
