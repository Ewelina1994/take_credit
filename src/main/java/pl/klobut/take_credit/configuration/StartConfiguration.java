package pl.klobut.take_credit.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.klobut.take_credit.domain.entities.CreditEntity;
import pl.klobut.take_credit.domain.entities.CustomerEntity;
import pl.klobut.take_credit.domain.entities.ProductEntity;
import pl.klobut.take_credit.repository.CreditRepo;
import pl.klobut.take_credit.repository.CustomerRepo;
import pl.klobut.take_credit.repository.ProductRepo;

@Configuration
public class StartConfiguration {

    private final CreditRepo creditRepo;
    private final ProductRepo productRepo;
    private final CustomerRepo customerRepo;

    public StartConfiguration(CreditRepo creditRepo, ProductRepo productRepo, CustomerRepo customerRepo) {
        this.creditRepo = creditRepo;
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }

    @Bean
    public CommandLineRunner initCredit() {
        return args -> {
            CreditEntity creditEntityOne = CreditEntity.builder()
                    .creditName("1/2021")
                    .build();
            CreditEntity creditEntityTwo = CreditEntity.builder()
                    .creditName("2/2021")
                    .build();
            creditRepo.saveAndFlush(creditEntityOne);
            creditRepo.saveAndFlush(creditEntityTwo);

            productRepo.saveAndFlush(ProductEntity.builder()
                    .productName("Kredyt hipoteczny")
                    .value(200000)
                    .credit(creditEntityOne)
                    .build());
            productRepo.saveAndFlush(ProductEntity.builder()
                    .productName("Kredyt gotówkowy")
                    .value(10000)
                    .credit(creditEntityTwo)
                    .build());
            customerRepo.saveAndFlush(CustomerEntity.builder()
                    .firstname("Artur")
                    .surname("Kowal")
                    .pesel("91020575600")
                    .credit(creditEntityOne)
                    .build());
            customerRepo.saveAndFlush(CustomerEntity.builder()
                    .firstname("Julia")
                    .surname("Kowal")
                    .pesel("94050345600")
                    .credit(creditEntityOne)
                    .build());
            customerRepo.saveAndFlush(CustomerEntity.builder()
                    .firstname("Jan")
                    .surname("Mak")
                    .pesel("88050345600")
                    .credit(creditEntityTwo)
                    .build());

        };
    }

}
