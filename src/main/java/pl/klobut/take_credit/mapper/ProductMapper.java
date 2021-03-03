package pl.klobut.take_credit.mapper;

import org.springframework.stereotype.Component;
import pl.klobut.take_credit.domain.entities.ProductEntity;
import pl.klobut.take_credit.domain.models.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper implements EntityMapper<Product, ProductEntity> {
    @Override
    public ProductEntity toEntity(Product product) {
        ProductEntity productEntity= new ProductEntity();
        productEntity.setProductName(product.getProductName());
        productEntity.setValue(product.getValue());

        return productEntity;
    }

    @Override
    public Product toDto(ProductEntity productEntity) {
        Product product = new Product();
        product.setProductName(productEntity.getProductName());
        product.setValue(productEntity.getValue());
        return product;
    }

    @Override
    public List<ProductEntity> toEntityList(List<Product> products) {
        List<ProductEntity> productEntityList= new ArrayList<>();
        products.forEach(p->{
            productEntityList.add(toEntity(p));
        });
        return productEntityList;
    }

    @Override
    public List<Product> toDtoList(List<ProductEntity> productEntities) {
        List<Product> productList= new ArrayList<>();
        productEntities.forEach(p->{
            productList.add(toDto(p));
        });
        return productList;
    }
}
