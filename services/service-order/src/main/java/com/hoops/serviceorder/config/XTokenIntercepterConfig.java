package com.hoops.serviceorder.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
public class XTokenIntercepterConfig implements RequestInterceptor{

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("XToken",UUID.randomUUID().toString());
    }
}
