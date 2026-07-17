package com.hoops.serviceproduct.controller;

import com.hoops.model.model.Product;
import com.hoops.serviceproduct.service.ProductService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable("id") Long productId,
                              HttpServletRequest httpServletRequest) throws Exception {
        System.out.println("被调用");
        return productService.getProductById(productId);
    }
}
