package com.hoops.serviceproduct.controller;

import com.hoops.model.model.Product;
import com.hoops.serviceproduct.model.ProductConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private ProductConfig productConfig;

    @GetMapping("/get")
    public String getConfig(){
        return productConfig.getTimeout()+productConfig.getAutoConfirm()+productConfig.getName()+"这是配置的输出";
    }
}
