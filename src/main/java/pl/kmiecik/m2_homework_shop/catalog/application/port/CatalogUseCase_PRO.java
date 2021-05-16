package pl.kmiecik.m2_homework_shop.catalog.application.port;

import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Profile("PLUS")
public interface CatalogUseCase_PRO extends CatalogUseCase_PLUS {
    @Override
    BigDecimal countTotalPrice();


}
