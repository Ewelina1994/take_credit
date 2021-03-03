package pl.klobut.take_credit.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.klobut.take_credit.entiti.Credit;
import pl.klobut.take_credit.entiti.Customer;
import pl.klobut.take_credit.entiti.Product;
import pl.klobut.take_credit.services.CreditService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/credit", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreditController {
    private CreditService creditService;
    private ProductController productController;
    private CustomerController customerController;

    public CreditController(CreditService creditService, ProductController productController, CustomerController customerController) {
        this.creditService = creditService;
        this.productController = productController;
        this.customerController = customerController;
    }

    @GetMapping()
    public Page<Credit> getCredits(Pageable pageable){
        return creditService.getAllCredits(pageable);
    }

//    @PostMapping()
//    public String addCredit(@RequestBody Customer customer, @RequestBody Product product){
//        Credit credit = new Credit();
//        creditService.addNewCredit(credit);
//        customerController.createCustomer(credit.getId(), customer);
//        productController.createProduct(credit.getId(), product);
//        return credit.getCreditName();
//    }
    @PostMapping()
    public String addCredit(@RequestBody Credit credit){
       creditService.addNewCredit(credit);
        return credit.getCreditName();
    }
}
