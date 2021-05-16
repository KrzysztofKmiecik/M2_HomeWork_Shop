package pl.kmiecik.m2_homework_shop.catalog.application.port;

import lombok.Value;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.math.BigDecimal;
import java.util.List;


public interface CatalogUseCase {
    List<Product> findAllProducts();

    void addProduct(CreateProductCommand command);

    BigDecimal countTotalPrice();

    @Value
    class CreateProductCommand {

        String name;
        BigDecimal price;

        public Product getProduct() {
            return new Product(name, price);
        }
    }

    String showProfile();


}
