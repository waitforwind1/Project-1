package com.hoops.serviceorder.service;

import com.hoops.model.model.Order;

public interface OrderService  {
     Order getOrder(Long userId,Long productId);
}
