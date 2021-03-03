package pl.klobut.take_credit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.klobut.take_credit.entiti.Product;
import pl.klobut.take_credit.exceptions.ResourceNotFoundException;
import pl.klobut.take_credit.services.CreditService;
import pl.klobut.take_credit.services.ProductService;

import javax.validation.Valid;

@Controller
public class ProductController {
    private ProductService productService;
    private CreditService creditService;

    @Autowired
    public ProductController(ProductService productService, CreditService creditService) {
        this.productService = productService;
        this.creditService = creditService;
    }

    public Product createProduct(Long creditId, @Valid Product product) throws ResourceNotFoundException {
        return creditService.getCreditById(creditId).map(credit -> {
            product.setCreditId(credit);
            return productService.addNewProduct(product);
        }).orElseThrow(() -> new ResourceNotFoundException("CreditId " + creditId + " not found"));
    }
}
