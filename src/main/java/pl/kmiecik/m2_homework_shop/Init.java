package pl.kmiecik.m2_homework_shop;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.m2_homework_shop.catalog.application.CatalogServiceBASIC;

import java.math.BigDecimal;

import static pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase.CreateProductCommand;

@Component
@AllArgsConstructor
public class Init {

    private final CatalogServiceBASIC service;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {


        service.addProduct(new CreateProductCommand("book1", new BigDecimal(100)));
        service.addProduct(new CreateProductCommand("book2", new BigDecimal(200)));
        service.addProduct(new CreateProductCommand("book3", new BigDecimal(300)));
        service.addProduct(new CreateProductCommand("book4", new BigDecimal(400)));
        service.addProduct(new CreateProductCommand("book5", new BigDecimal(500)));

        System.out.println(service.findAllProducts());
        System.out.println("TOTAL price = " + service.countTotalPrice());
    }
}
