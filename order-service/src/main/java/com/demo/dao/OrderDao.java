package com.demo.dao;

import com.demo.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    Order selectOrderById(@Param("orderId") Long id);
}
