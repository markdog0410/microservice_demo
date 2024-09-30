package com.demo.dao;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User selectUserById(@Param("userId") Long id);
}
