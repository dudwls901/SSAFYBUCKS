package com.ssafy.cafe.vue.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.service.FirebaseCloudMessageService;
import com.ssafy.cafe.vue.dto.Order;
import com.ssafy.cafe.vue.dto.OrderDetail;
import com.ssafy.cafe.vue.dto.Stamp;
import com.ssafy.cafe.vue.dto.User;
import com.ssafy.cafe.vue.repo.OrderRepo;
import com.ssafy.cafe.vue.repo.OrderDetailRepo;
import com.ssafy.cafe.vue.repo.StampRepo;
import com.ssafy.cafe.vue.repo.UserRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo oRepo;

	@Autowired
	private OrderDetailRepo odRepo;

	@Autowired
	private StampRepo sRepo;

	@Autowired
	private UserRepo uRepo;

	@Autowired
	FirebaseCloudMessageService fService;

	@Override
	public void makeOrder(Map<String, Object> orderInfo) {
		// 넘어온 데이터 예시
		// id : prodcutId, count : quantity
		// {orders=[{id=1, name=coffee1, type=coffee, price=1, img=coffee1.png,
		// count=2}, {id=5, name=coffee5, type=coffee, price=5, img=coffee5.png,
		// count=3}], userId=123}

		// 넘어온 데이터를 Order 타입으로 변환
		String userId = (String) orderInfo.get("userId");
		List<Map<String, Object>> orderDetails = (List<Map<String, Object>>) orderInfo.get("details");

		List<OrderDetail> newOrderDetails = new ArrayList<>();
		for (Map<String, Object> orderDetail : orderDetails) {
			OrderDetail newOrderDetail = new OrderDetail();
			newOrderDetail.setProductId((Integer) orderDetail.get("id"));
			newOrderDetail.setQuantity((Integer) orderDetail.get("quantity"));
			newOrderDetails.add(newOrderDetail);
		}

		Order order = new Order();
		order.setUserId(userId);
		order.setDetails(newOrderDetails);

		// 본격적인 주문 시작
		oRepo.insert(order);
		List<OrderDetail> orderDetailList = order.getDetails();

		int totalQuantity = 0;
		for (OrderDetail orderDetail : orderDetailList) {
			orderDetail.setOrderId(order.getId());
			odRepo.insert(orderDetail);
			totalQuantity += orderDetail.getQuantity();
		}

		// 스탬프 적립
		Stamp stamp = new Stamp(order.getUserId(), order.getId(), totalQuantity);
		sRepo.insert(stamp);

		// 유저의 스탬프양 업데이트
		User user = uRepo.select(order.getUserId());
		user.setStamps(user.getStamps() + totalQuantity);
		uRepo.update(user);

		// 관리자에게 메시지 전송
		try {
			fService.sendMessageTo("admin", "주문 알림", user.getId() + "님이 주문을 하였습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Order getOrderWithDetails(Integer orderId) {

		Order order = oRepo.select(orderId);

		// detail가져와서 order에 추가
		List<OrderDetail> orderDetailList = odRepo.selectByOrderId(orderId);
		order.setDetails(orderDetailList);

		return order;
	}

	@Override
	public List<Order> getOrdreByUser(String id) {
		List<Order> orderList = oRepo.selectByUser(id);
		return orderList;
	}

	@Override
	public void updateOrder(Order order) {
		oRepo.update(order);
	}

	@Override
	public List<OrderDetail> selectOrderTotalInfo(Integer productId) {
		return odRepo.selectByProductId(productId);
	}

}
