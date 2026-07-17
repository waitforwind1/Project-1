package com.hoops.serviceorder.service.Impl;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.hoops.model.model.Order;
import com.hoops.model.model.Product;
import com.hoops.serviceorder.FeignClient.ProductFeignClient;
import com.hoops.serviceorder.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    /**
     * 引入OpenFeign设置的远程调用客户端
     */
    private final ProductFeignClient productFeignClient;

    @Override
    public Order getOrder(Long userId,Long productId) {
        Product product = productFeignClient.getProduct(productId);
        BigDecimal totalAmount = BigDecimal.ZERO;
        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(2L);
        if (product != null) {
            totalAmount =product.getPrice().multiply(new BigDecimal(2));
            order.setProductList(List.of(product));
        }
        order.setTotalAmount(totalAmount);
        return order;
    }
}
