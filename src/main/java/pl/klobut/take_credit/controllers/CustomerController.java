package pl.klobut.take_credit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.klobut.take_credit.entiti.Customer;
import pl.klobut.take_credit.exceptions.ResourceNotFoundException;
import pl.klobut.take_credit.services.CreditService;
import pl.klobut.take_credit.services.CustomerService;

import javax.validation.Valid;

@RestController
public class CustomerController {
    private CreditService creditService;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CreditService creditService, CustomerService customerService) {
        this.creditService = creditService;
        this.customerService = customerService;
    }

    @PostMapping("/credits/{creditId}/customer")
    public Customer createCustomer(@PathVariable(value = "creditId") Long creditId,
                                  @Valid @RequestBody Customer customer) throws ResourceNotFoundException {
        return creditService.getCreditById(creditId).map(credit -> {
            customer.setCreditId(credit);
            return customerService.addNewCustomer(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("CreditId " + creditId + " not found"));
    }
}
