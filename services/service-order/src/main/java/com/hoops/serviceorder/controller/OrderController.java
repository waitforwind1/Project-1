package com.hoops.serviceorder.controller;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hoops.model.model.Order;
import com.hoops.serviceorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @SentinelResource(value = "orderResource",fallback = "orderFallback")
    @GetMapping("/create")
    public Order getOrder(Long userId,Long productId){
        log.info("创建订单"+ LocalDateTime.now());
        return orderService.getOrder(userId,productId);
    }

    @GetMapping("/secKill")
    public Order secKill(Long userId,Long productId){
        return orderService.getOrder(userId,productId);
    }

    @GetMapping ("/writeDB")
    public String writeDb(){
        return "writeDb";
    }

    @GetMapping ("/readDB")
    public String readDb(){
        return "readDB";
    }

    private Order orderBlockHandler(Long userId,Long productId,BlockException exception){
        System.out.println(exception.getClass());
        return orderService.getOrder(userId,productId);
    }

    private Order orderFallback(Long userId,Long productId,BlockException exception){
        Order order = new Order();
        order.setId(9999L);
        order.setUserId(9999L);
        order.setAddress("9999L");
        order.setProductId(9999L);
        order.setQuantity(9999L);
        order.setTotalAmount(new BigDecimal("9999"));
        return order;
    }

}
