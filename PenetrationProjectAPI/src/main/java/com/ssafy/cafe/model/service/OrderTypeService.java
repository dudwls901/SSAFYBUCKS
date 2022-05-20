package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.OrderType;

public interface OrderTypeService {
	
	void addOrderType(OrderType orderType);
	
	void addOrderTypeWithOrderId(Integer orderId);
	
	OrderType selectByOrder(Integer orderId);

	List<OrderType> selectAll();

}
