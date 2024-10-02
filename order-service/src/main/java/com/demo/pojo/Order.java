package com.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long orderId;
    private Long userId;
    private String productName;
    private Integer price;
    private Integer quantity;
    private User user;
}
