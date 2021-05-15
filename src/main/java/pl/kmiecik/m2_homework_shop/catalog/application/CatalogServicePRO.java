package pl.kmiecik.m2_homework_shop.catalog.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCasePLUS;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.math.BigDecimal;
import java.util.List;

@Service
@Profile("PRO")
class CatalogServicePRO implements CatalogUseCase {

    private CatalogUseCasePLUS catalogServicePLUS;

  /*  @Value("${shop-param.vat}")
    private String vat;*/


    @Value("${shop-param.discount}")
    private String dicount;


    @Override
    public List<Product> findAllProducts() {
        return catalogServicePLUS.findAllProducts();
    }

    @Override
    public void addProduct(CreateProductCommand command) {
        catalogServicePLUS.addProduct(command);
    }

    public BigDecimal countTotalPrice() {
        //    BigDecimal taxRate = super.getTaxRate(this.vat);
        BigDecimal priceWithTax = catalogServicePLUS.countTotalPrice();
        BigDecimal discount = priceWithTax.multiply(getDiscont(this.dicount));

        return priceWithTax.subtract(discount);
    }

    private BigDecimal getDiscont(String dicount) {
        final BigDecimal ONE_HUNDRED = new BigDecimal("100");
        BigDecimal discountRatePercentage = new BigDecimal(dicount).divide(ONE_HUNDRED);
        return discountRatePercentage;
    }

}
