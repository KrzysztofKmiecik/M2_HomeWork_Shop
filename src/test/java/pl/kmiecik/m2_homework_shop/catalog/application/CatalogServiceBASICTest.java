package pl.kmiecik.m2_homework_shop.catalog.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kmiecik.m2_homework_shop.catalog.domain.CatalogRepository;
import pl.kmiecik.m2_homework_shop.catalog.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CatalogServiceBASICTest {
    @Mock
    private CatalogRepository catalogRepository;

    @InjectMocks
    CatalogServiceBASIC catalogServiceBASIC;

    @Test
    void shouldReturn300TotalPrice() {

        List<Product> list = new ArrayList<>();
        list.add(new Product("book1", new BigDecimal("100")));
        list.add(new Product("book2", new BigDecimal("200")));

        when(catalogRepository.findAll()).thenReturn(list);
        BigDecimal actual = catalogServiceBASIC.countTotalPrice();

        BigDecimal expected = new BigDecimal("300.00");

        assertEquals(expected, actual);
    }
}