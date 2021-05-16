package pl.kmiecik.m2_homework_shop.catalog.application.port;

import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Profile({"BASIC", "PLUS", "PRO"})
public interface CatalogUseCase_BASIC extends CatalogUseCase {

    @Override
    BigDecimal countTotalPrice();


}
