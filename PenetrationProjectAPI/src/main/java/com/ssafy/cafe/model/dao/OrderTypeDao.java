package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.OrderType;

public interface OrderTypeDao {

	int insert(OrderType orderType);

	int insertWithOrderId(Integer orderId);

	int update(OrderType orderType);

	int delete(OrderType orderType);

	OrderType selectByOrder(Integer orderId);

	List<OrderType> selectAll();

}
