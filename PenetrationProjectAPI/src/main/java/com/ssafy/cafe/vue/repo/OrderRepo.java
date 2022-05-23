package com.ssafy.cafe.vue.repo;

import java.util.List;

import com.ssafy.cafe.vue.dto.Order;

public interface OrderRepo {
    int insert(Order order);

    int update(Order order);

    int delete(Integer orderId);

    Order select(Integer orderId);

    List<Order> selectAll();
    
    Order selectWithDetail(int id);
    
    List<Order> selectByUser(String userId);
}
