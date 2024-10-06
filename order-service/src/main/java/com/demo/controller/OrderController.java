package com.demo.controller;


import com.demo.pojo.Order;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Order queryById(@PathVariable("id") Long id) {
//        public Order queryById(@PathVariable("id") Long id, @RequestHeader(value = "Global") String global) {
//        System.out.println("order filter data => " + global);
        return orderService.selectOrderById(id);
    }
}
