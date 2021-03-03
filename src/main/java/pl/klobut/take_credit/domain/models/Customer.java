package pl.klobut.take_credit.domain.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.klobut.take_credit.validators.ValidPESEL;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @NonNull
    private String firstname;
    @NonNull
    private String surname;
    @NotNull
    @ValidPESEL
    @Pattern(regexp = "[0-9]*")
    private String pesel;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
