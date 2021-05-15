package pl.kmiecik.m2_homework_shop.catalog.infrastructure;

import org.springframework.stereotype.Repository;
import pl.kmiecik.m2_homework_shop.catalog.domain.CatalogRepository;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryCatalogRepository implements CatalogRepository {

    private final Map<Long, Product> storage = new HashMap<>();
    private  Long myId=0L;


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void addProduct(Product product) {

        storage.put(myId, product);
        myId++;
    }
}
