package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.cafe.model.dao.OrderTypeDao;
import com.ssafy.cafe.model.dto.OrderType;

public class OrderTypeServiceImpl implements OrderTypeService {
	
	@Autowired
	OrderTypeDao otDao;

	@Override
	public void addOrderType(OrderType orderType) {
		otDao.insert(orderType);
	}

	@Override
	public void addOrderTypeWithOrderId(Integer orderId) {
		otDao.insertWithOrderId(orderId);
	}

	@Override
	public OrderType selectByOrder(Integer orderId) {
		return otDao.selectByOrder(orderId);
	}

	@Override
	public List<OrderType> selectAll() {
		return otDao.selectAll();
	}

}
