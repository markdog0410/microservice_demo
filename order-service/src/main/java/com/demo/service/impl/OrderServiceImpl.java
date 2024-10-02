package com.demo.service.impl;

import com.demo.clients.UserClient;
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
    private UserClient userClient;

    /**
     * Feign 用於取代 restTemplate 去呼叫其他 project api
     */
    @Override
    public Order selectOrderById(Long id) {
        Order order = orderDao.selectOrderById(id);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }


    /*

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
     */
}
