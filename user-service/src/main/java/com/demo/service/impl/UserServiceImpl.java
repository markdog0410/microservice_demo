package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(Long id) {
        return userDao.selectUserById(id);
    }
}
