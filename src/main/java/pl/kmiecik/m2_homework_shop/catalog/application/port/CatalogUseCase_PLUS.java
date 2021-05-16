package pl.kmiecik.m2_homework_shop.catalog.application.port;

import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Profile({"PLUS", "PRO"})
public interface CatalogUseCase_PLUS extends CatalogUseCase_BASIC {
    @Override
    BigDecimal countTotalPrice();


}
