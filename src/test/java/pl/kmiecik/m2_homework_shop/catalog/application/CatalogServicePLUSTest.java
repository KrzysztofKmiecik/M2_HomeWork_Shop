package pl.kmiecik.m2_homework_shop.catalog.application;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CatalogServicePLUSTest {
    @Mock
    CatalogServiceBASIC catalogServiceBASIC;

    @InjectMocks
    CatalogServicePLUS catalogServicePLUS;

    @Test
    @Ignore
    public void countTotalPrice() {

        when(catalogServiceBASIC.countTotalPrice()).thenReturn(new BigDecimal("300"));
        when(catalogServicePLUS.getTaxRate()).thenReturn(new BigDecimal("1.20"));
        BigDecimal actual = catalogServicePLUS.countTotalPrice();

        BigDecimal expected = new BigDecimal("360.00");

        assertEquals(expected, actual);

    }
}