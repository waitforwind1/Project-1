package com.hoops.serviceorder.config;

import feign.RequestInterceptor;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

public class FeignRetryConfig {

    @Bean
    public RequestInterceptor logInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("Auth", UUID.randomUUID().toString());
        };
    }

    @Bean
    public Retryer retryer(){
        return new Retryer.Default(
                100,100,3
        );
    }
}
