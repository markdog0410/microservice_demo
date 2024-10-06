package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id){
//        public User queryById(@PathVariable("id") Long id, @RequestHeader(value = "Truth") String truth){
//        System.out.println("filter data =>> " + truth);
        return userService.selectUserById(id);
    }
}
