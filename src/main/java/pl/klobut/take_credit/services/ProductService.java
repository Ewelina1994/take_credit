package pl.klobut.take_credit.services;

import org.springframework.stereotype.Service;
import pl.klobut.take_credit.entiti.Product;
import pl.klobut.take_credit.repository.ProductRepo;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Optional<Product> getProductsByCreditId(Long id){
        return productRepo.findAllByCreditId(id);
    }

    public Product addNewProduct(Product product){
        return productRepo.save(product);
    }
}
