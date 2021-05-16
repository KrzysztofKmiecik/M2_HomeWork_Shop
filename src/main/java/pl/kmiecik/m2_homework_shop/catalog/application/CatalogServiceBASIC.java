package pl.kmiecik.m2_homework_shop.catalog.application;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase_BASIC;
import pl.kmiecik.m2_homework_shop.catalog.domain.CatalogRepository;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
@Profile({"BASIC", "PLUS", "PRO"})
class CatalogServiceBASIC implements CatalogUseCase_BASIC {

    private final CatalogRepository repository;

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public void addProduct(CreateProductCommand command) {
        repository.addProduct(command.getProduct());
    }

    @Override
    public BigDecimal countTotalPrice() {
        return repository.findAll()
                .stream()
                .map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
