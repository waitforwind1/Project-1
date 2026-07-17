package com.hoops.serviceorder.config;

import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NacosTemplateConfig {

    /**
     * 配置了重试策略 这是系统默认配置的重试策略 100ms  1s  5次
     * @return
     */
    @Bean
    public Retryer retryer(){
        return new Retryer.Default();
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
