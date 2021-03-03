package pl.klobut.take_credit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.klobut.take_credit.domain.entities.CreditEntity;
import pl.klobut.take_credit.domain.models.Credit;
import pl.klobut.take_credit.domain.models.Customer;
import pl.klobut.take_credit.domain.models.Product;
import pl.klobut.take_credit.mapper.CreditMapper;
import pl.klobut.take_credit.repository.CreditRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditService {
    private CreditRepo creditRepo;
    private CreditMapper creditMapper;
    private CustomerService customerService;
    private ProductService productService;

    @Autowired
    public CreditService(CreditRepo creditRepo, CreditMapper creditMapper, CustomerService customerService, ProductService productService) {
        this.creditRepo = creditRepo;
        this.creditMapper = creditMapper;
        this.customerService = customerService;
        this.productService = productService;
    }

    public Optional<CreditEntity> getCreditById(Long idCredit) {
        return creditRepo.findById(idCredit);
    }

    public List<Credit> getAllCredits() {
        //get all creditsEntity by database
        List<CreditEntity> creditEntities = creditRepo.findAll();
        List<Credit> creditList = new ArrayList<>();
        //iterable to each creditEntiti and create new Credit object
        creditEntities.stream().forEach(creditEntity -> {
            Credit credit = creditMapper.toDto(creditEntity);
            List<Product> productsByCreditId = productService.getProductsByCreditId(creditEntity.getId());
            List<Customer> customersByCreditId = customerService.getCustomersByCreditId(creditEntity.getId());
            credit.setProducts(productsByCreditId);
            credit.setCustomers(customersByCreditId);

            creditList.add(credit);
        });

        return creditList;
    }

    public CreditEntity addNewCredit(Credit credit) {
        //add credit to database
        CreditEntity creditId = saveAndGetNrCredit(credit);
        //send list Customers to serviceCustomer
        customerService.addNewCustomers(credit.getCustomers(), creditId);
        productService.addNewProducts(credit.getProducts(), creditId);
        return creditId;
    }

    private CreditEntity saveAndGetNrCredit(Credit credit) {
        CreditEntity creditEntity = creditMapper.toEntity(credit);
        return creditRepo.save(creditEntity);
    }

    public Optional<CreditEntity> findById(Long valueOf) {
        return creditRepo.findById(valueOf);
    }
}
