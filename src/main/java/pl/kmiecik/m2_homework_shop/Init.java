package pl.kmiecik.m2_homework_shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase;

import java.math.BigDecimal;

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
        service.addProduct(new CreateProductCommand("book1", new BigDecimal(100)));
        service.addProduct(new CreateProductCommand("book2", new BigDecimal(200)));
        service.addProduct(new CreateProductCommand("book3", new BigDecimal(300)));
        service.addProduct(new CreateProductCommand("book4", new BigDecimal(400)));
        service.addProduct(new CreateProductCommand("book5", new BigDecimal(500)));

        service.findAllProducts().forEach(System.out::println);
        System.out.println("TOTAL price = " + service.countTotalPrice());
    }
}
