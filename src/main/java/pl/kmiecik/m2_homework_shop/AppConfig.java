package pl.kmiecik.m2_homework_shop;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kmiecik.m2_homework_shop.catalog.application.port.CatalogUseCase;

@Configuration
@AllArgsConstructor
public class AppConfig {

    private ApplicationContext context;

    @Bean
    public CatalogUseCase MyServiceAlias(@Value("${spring.profiles.active}") String qualifier) {
        return (CatalogUseCase) context.getBean("catalogService"+qualifier);
    }

}
