package com.hoops.serviceproduct.service.Impl;
import java.math.BigDecimal;

import com.hoops.model.model.Product;
import com.hoops.serviceproduct.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setDescription("模拟产品");
        product.setName("产品型号:"+productId);
        product.setPrice(new BigDecimal("99"));
        product.setStock(100);
        return product;
    }
}
