package com.hoops.model.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String description;
    private String name;
    private BigDecimal price;
    private Integer stock;

}
