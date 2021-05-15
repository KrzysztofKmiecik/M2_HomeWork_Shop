package pl.kmiecik.m2_homework_shop.catalog.application;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase.CreateProductCommand;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase_BASIC;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase_PLUS;
import pl.kmiecik.m2_homework_shop.catalog.domain.CatalogRepository;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.math.BigDecimal;
import java.util.List;

@Service
@Profile({"PLUS"})
@AllArgsConstructor
class CatalogServicePLUS implements CatalogUseCase_PLUS {

    private final CatalogUseCase_BASIC catalogUseCase_basic;

    @Value("${shop-param.vat}")
    private String vat;


    @Override
    public List<Product> findAllProducts() {
        return catalogUseCase_basic.findAllProducts();
    }

    @Override
    public void addProduct(CreateProductCommand command) {
        catalogUseCase_basic.addProduct(command);
    }


    public BigDecimal countTotalPrice() {
        BigDecimal taxRate = getTaxRate(this.vat);
        return catalogUseCase_basic.countTotalPrice().multiply(taxRate);
    }

    protected BigDecimal getTaxRate(String vat) {
        final BigDecimal ONE_HUNDRED = new BigDecimal("100");
        BigDecimal taxRatePercentage = new BigDecimal(vat).divide(ONE_HUNDRED);
        BigDecimal taxRate = taxRatePercentage.add(BigDecimal.ONE);
        return taxRate;
    }
}
