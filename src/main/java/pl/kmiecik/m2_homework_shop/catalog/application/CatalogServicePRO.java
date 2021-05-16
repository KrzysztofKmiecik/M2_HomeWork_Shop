package pl.kmiecik.m2_homework_shop.catalog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase_PLUS;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase_PRO;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Profile("PRO")
class CatalogServicePRO implements CatalogUseCase_PRO {
    private final CatalogUseCase_PLUS catalogUseCase_plus;

    @Value("${shop-param.vat}")
    private String vat;


    @Value("${shop-param.discount}")
    private String dicount;

    @Autowired
    CatalogServicePRO(@Qualifier("catalogServicePLUS") CatalogUseCase_PLUS catalogUseCase_plus) {
        this.catalogUseCase_plus = catalogUseCase_plus;
    }


    @Override
    public List<Product> findAllProducts() {
        return catalogUseCase_plus.findAllProducts();
    }

    @Override
    public void addProduct(CreateProductCommand command) {
        catalogUseCase_plus.addProduct(command);
    }

    @Override
    public BigDecimal countTotalPrice() {
        //    BigDecimal taxRate = super.getTaxRate(this.vat);

        BigDecimal priceWithTax = catalogUseCase_plus.countTotalPrice();
        BigDecimal discount = priceWithTax.multiply(getDiscont(this.dicount));

        return priceWithTax.subtract(discount).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String showProfile() {
        return "You are in " + "PRO " + "Shop" + "\nTOTAL price= SumPrice*TAX-discount";
    }

    private BigDecimal getDiscont(String dicount) {
        final BigDecimal ONE_HUNDRED = new BigDecimal("100");
        BigDecimal discountRatePercentage = new BigDecimal(dicount).divide(ONE_HUNDRED);
        return discountRatePercentage;
    }

}
