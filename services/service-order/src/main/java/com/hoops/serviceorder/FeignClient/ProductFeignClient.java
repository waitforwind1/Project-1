package com.hoops.serviceorder.FeignClient;

import com.hoops.model.model.Product;
import com.hoops.serviceorder.config.FeignRetryConfig;
import com.hoops.serviceorder.config.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-product",
            fallback = ProductClientFallback.class,
            configuration =  FeignRetryConfig.class)
public interface ProductFeignClient {
    @GetMapping("/product/get/{id}")
    Product getProduct(@PathVariable("id") Long productId);

}
