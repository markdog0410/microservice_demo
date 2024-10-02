package com.demo.service.impl;

import com.demo.dao.OrderDao;
import com.demo.pojo.Order;
import com.demo.pojo.User;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order selectOrderById(Long id) {
        Order order = orderDao.selectOrderById(id);
        String url = "http://user-service/user/" + order.getOrderId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
