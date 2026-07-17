package com.hoops.serviceorder.config;

import com.hoops.model.model.Product;
import com.hoops.serviceorder.FeignClient.ProductFeignClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 服务熔断 兜底返回数据
 */
@Component
public class ProductClientFallback implements ProductFeignClient {
    @Override
    public Product getProduct(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setDescription("商品无库存");
        product.setName("00");
        product.setPrice(BigDecimal.valueOf(9999));
        product.setStock(0);
        return product;
    }
}
