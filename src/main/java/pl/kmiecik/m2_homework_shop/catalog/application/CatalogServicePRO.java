package pl.kmiecik.m2_homework_shop.catalog.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kmiecik.m2_homework_shop.catalog.domain.CatalogRepository;

import java.math.BigDecimal;

@Service
@Profile("PRO")
public class CatalogServicePRO extends CatalogServicePLUS {


  /*  @Value("${shop-param.vat}")
    private String vat;*/


    @Value("${shop-param.discount}")
    private String dicount;

    public CatalogServicePRO(CatalogRepository repository) {
        super(repository);
    }


    @Override
    public BigDecimal countTotalPrice() {
        //    BigDecimal taxRate = super.getTaxRate(this.vat);
        BigDecimal priceWithTax = super.countTotalPrice();
        BigDecimal discount = priceWithTax.multiply(getDiscont(this.dicount));

        return priceWithTax.subtract(discount);
    }

    private BigDecimal getDiscont(String dicount) {
        final BigDecimal ONE_HUNDRED = new BigDecimal("100");
        BigDecimal discountRatePercentage = new BigDecimal(dicount).divide(ONE_HUNDRED);
        return discountRatePercentage;
    }

}
