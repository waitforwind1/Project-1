package com.hoops.model.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    private Long id;
    private Long userId;
    private String address;
    private Long productId;
    private Long quantity;
    private BigDecimal totalAmount;
    private List<Product> productList;
}
