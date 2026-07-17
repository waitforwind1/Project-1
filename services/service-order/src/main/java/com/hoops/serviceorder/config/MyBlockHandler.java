package com.hoops.serviceorder.config;
import java.math.BigDecimal;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoops.model.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyBlockHandler implements BlockExceptionHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       String s, BlockException e) throws Exception {
        R error = R.error("500","被sentinel拦截了",null);
        String json = objectMapper.writeValueAsString(error);
        httpServletResponse.setStatus(429);
        httpServletResponse.setContentType("application/json;charset = utf-8");
        httpServletResponse.getWriter().write(json);
        httpServletResponse.getWriter().flush();
    }
}
