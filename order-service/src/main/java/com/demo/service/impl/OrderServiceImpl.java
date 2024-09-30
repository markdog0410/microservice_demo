package com.demo.service.impl;

import com.demo.dao.OrderDao;
import com.demo.pojo.Order;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order selectOrderById(Long id) {
        return orderDao.selectOrderById(id);
    }
}
