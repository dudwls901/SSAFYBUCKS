package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.cafe.model.dao.OrderDao;
import com.ssafy.cafe.model.dao.OrderDetailDao;
import com.ssafy.cafe.model.dao.OrderTypeDao;
import com.ssafy.cafe.model.dao.StampDao;
import com.ssafy.cafe.model.dao.UserDao;
import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.OrderDetail;
import com.ssafy.cafe.model.dto.OrderType;
import com.ssafy.cafe.model.dto.Stamp;
import com.ssafy.cafe.model.dto.User;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao oDao;

	@Autowired
	OrderDetailDao dDao;

	@Autowired
	StampDao sDao;

	@Autowired
	UserDao uDao;

	@Autowired
	OrderTypeDao otDao;

	@Override
	@Transactional
	public int makeOrder(Map<String, Object> map) {

		Order order = new Order();
		String type = "out";

		// 매장(in)에서 주문한 경우
		if (map.get("type") != null && ((String) map.get("type")).equals("in")) {
			type = "in";
			ObjectMapper mapper = new ObjectMapper();
			order = mapper.convertValue(map.get("order"), new TypeReference<Order>() {
			});
		} else {
			ObjectMapper mapper = new ObjectMapper();
			order = mapper.convertValue(map.get("order"), new TypeReference<Order>() {
			});
//			order = mapper.convertValue(map, new TypeReference<Order>() {
//			});
		}

		// 주문 및 주문 상세 테이블 저장
		oDao.insert(order);
		List<OrderDetail> details = order.getDetails();
		int quantitySum = 0;
		for (OrderDetail detail : details) {
			detail.setOrderId(order.getId());
			dDao.insert(detail);
			quantitySum += detail.getQuantity();
		}

		// 주문 타입 저장 (매장인지 테이크아웃인지)
		OrderType orderType = new OrderType(order.getId(), type);
		otDao.insert(orderType);

		// 스템프 정보 저장
		Stamp stamp = Stamp.builder().userId(order.getUserId()).quantity(quantitySum).orderId(order.getId()).build();
		sDao.insert(stamp);
		// 사용자 정보 업데이트
		User user = User.builder().id(order.getUserId()).stamps(stamp.getQuantity()).build();
		uDao.updateStamp(user);

		return order.getId();
	}

	@Override
	public Order getOrderWithDetails(Integer orderId) {
		return oDao.selectWithDetail(orderId);
	}

	@Override
	public List<Order> getOrdreByUser(String id) {
		return oDao.selectByUser(id);
	}

	@Override
	public void updateOrder(Order order) {
		oDao.update(order);
	}

	@Override
	public List<Map> selectOrderTotalInfo(int id) {
		return oDao.selectOrderTotalInfo(id);
	}

	@Override
	public List<Map<String, Object>> getLastMonthOrder(String id) {
		return oDao.getLastMonthOrder(id);
	}

	@Override
	public List<OrderDetail> getAllOrderDetail() {
		return dDao.selectAll();
	}
	
	@Override
	public List<Map<String, Object>> getDayOrder(String date){
		return oDao.getDayOrder(date);
	}
	
	@Override
	public void changeOrderComplete(int order_id) {
		oDao.changeOrderComplete(order_id);
	}

}
