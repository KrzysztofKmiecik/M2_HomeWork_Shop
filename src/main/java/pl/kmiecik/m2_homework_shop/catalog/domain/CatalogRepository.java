package pl.kmiecik.m2_homework_shop.catalog.domain;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {

    List<Product> findAll();
    Optional<Product> findById(Long id);

    void addProduct(Product product);
}
