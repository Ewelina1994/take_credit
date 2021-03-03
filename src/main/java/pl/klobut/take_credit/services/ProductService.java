package pl.klobut.take_credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.klobut.take_credit.domain.entities.CreditEntity;
import pl.klobut.take_credit.domain.entities.ProductEntity;
import pl.klobut.take_credit.domain.models.Product;
import pl.klobut.take_credit.exceptions.ResourceNotFoundException;
import pl.klobut.take_credit.mapper.ProductMapper;
import pl.klobut.take_credit.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;
    private ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public List<Product> getProductsByCreditId(Long id) {
        List<ProductEntity> allByCreditId = productRepo.findAllByCreditId(id);
        if (allByCreditId.isEmpty()) {
            new ResourceNotFoundException("Custorm with credit id: " + id + " not found");
        }
        List<Product> productList = productMapper.toDtoList(allByCreditId);
        return productList;
    }

    public ProductEntity addNewProduct(ProductEntity product) {
        return productRepo.save(product);
    }

    public List<ProductEntity> addNewProducts(List<Product> products, CreditEntity creditId) {
        List<ProductEntity> productEntityList = new ArrayList<>();
        products.stream().forEach(product -> {
            ProductEntity productEntity = productMapper.toEntity(product);
            productEntity.setCredit(creditId);
            productEntityList.add(productEntity);
        });
        return productRepo.saveAll(productEntityList);
    }
}
