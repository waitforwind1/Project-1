package com.hoops.serviceproduct.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "product")
public class ProductConfig {
    private String timeout;
    private String autoConfirm;
    private String name;
}
