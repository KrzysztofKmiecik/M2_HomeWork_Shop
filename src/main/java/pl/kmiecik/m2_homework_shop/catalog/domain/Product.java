package pl.kmiecik.m2_homework_shop.catalog.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Product {
    private String name;
    private BigDecimal price;


}
