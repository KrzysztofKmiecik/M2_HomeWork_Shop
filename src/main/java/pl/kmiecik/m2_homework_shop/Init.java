package pl.kmiecik.m2_homework_shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase.CreateProductCommand;

@Component
public class Init {
    private CatalogUseCase service;

/*    @Value("${spring.profiles.active}")
    private String activProfile;*/


    @Autowired
    public Init(@Qualifier("MyServiceAlias") CatalogUseCase service) {
        this.service = service;

    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println();
        System.out.println(service.showProfile());
        System.out.println();
        service.addProduct(new CreateProductCommand("book1", generateRandomBigDecimalFromRange(BigDecimal.valueOf(100L), BigDecimal.valueOf(300L))));
        service.addProduct(new CreateProductCommand("book2", generateRandomBigDecimalFromRange(BigDecimal.valueOf(100L), BigDecimal.valueOf(300L))));
        service.addProduct(new CreateProductCommand("book3", generateRandomBigDecimalFromRange(BigDecimal.valueOf(100L), BigDecimal.valueOf(300L))));
        service.addProduct(new CreateProductCommand("book4", generateRandomBigDecimalFromRange(BigDecimal.valueOf(100L), BigDecimal.valueOf(300L))));
        service.addProduct(new CreateProductCommand("book5", generateRandomBigDecimalFromRange(BigDecimal.valueOf(100L), BigDecimal.valueOf(300L))));

        service.findAllProducts().forEach(System.out::println);
        System.out.println("TOTAL price = " + service.countTotalPrice());

    }

    public static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        double random = Math.random();
        BigDecimal randomBigDecimal = min.add(new BigDecimal(random).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
    }
}
