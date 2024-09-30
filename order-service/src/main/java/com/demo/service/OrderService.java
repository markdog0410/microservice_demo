package com.demo.service;

import com.demo.pojo.Order;

public interface OrderService {

    Order selectOrderById(Long id);
}
