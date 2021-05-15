package pl.kmiecik.m2_homework_shop.catalog.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kmiecik.m2_homework_shop.catalog.domain.CatalogRepository;

import java.math.BigDecimal;

@Service
@Profile("PLUS")
public class CatalogServicePLUS extends CatalogServiceBASIC {

    @Value("${shop-param.vat}")
    private String vat;

    public CatalogServicePLUS(CatalogRepository repository) {
        super(repository);
    }

    @Override
    public BigDecimal countTotalPrice() {
        BigDecimal taxRate = getTaxRate(this.vat);
        return super.countTotalPrice().multiply(taxRate);
    }

    protected BigDecimal getTaxRate(String vat) {
        final BigDecimal ONE_HUNDRED = new BigDecimal("100");
        BigDecimal taxRatePercentage = new BigDecimal(vat).divide(ONE_HUNDRED);
        BigDecimal taxRate = taxRatePercentage.add(BigDecimal.ONE);
        return taxRate;
    }
}
