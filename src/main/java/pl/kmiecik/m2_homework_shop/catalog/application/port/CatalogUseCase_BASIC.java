package pl.kmiecik.m2_homework_shop.catalog.application.port;

import lombok.Value;
import org.springframework.context.annotation.Profile;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.math.BigDecimal;
import java.util.List;

@Profile({"BASIC","PLUS","PRO"})
public interface CatalogUseCase_BASIC extends CatalogUseCase {

    @Override
    BigDecimal countTotalPrice();


}
