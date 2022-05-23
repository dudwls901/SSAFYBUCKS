package com.ssafy.cafe.vue.repo;

import java.util.List;

import com.ssafy.cafe.vue.dto.OrderDetail;

public interface OrderDetailRepo {
    int insert(OrderDetail detail);

    int delete(Integer detailId);

    OrderDetail select(Integer detailId);

    List<OrderDetail> selectAll();
    
    List<OrderDetail> selectByProductId(Integer productId);
    
    List<OrderDetail> selectByOrderId(Integer orderId);
}
