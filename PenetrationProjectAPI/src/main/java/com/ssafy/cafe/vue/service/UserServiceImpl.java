package com.ssafy.cafe.vue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.cafe.vue.dto.Order;
import com.ssafy.cafe.vue.dto.OrderDetail;
import com.ssafy.cafe.vue.dto.Stamp;
import com.ssafy.cafe.vue.dto.User;
import com.ssafy.cafe.vue.repo.OrderDetailRepo;
import com.ssafy.cafe.vue.repo.OrderRepo;
import com.ssafy.cafe.vue.repo.StampRepo;
import com.ssafy.cafe.vue.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService { // 주석남깁니다.

	@Autowired
	private UserRepo uRepo;

	@Autowired
	private OrderRepo oRepo;
	
	@Autowired
	private OrderDetailRepo odRepo;

	@Autowired
	private StampRepo sRepo;

	@Override
	public int join(User user) {
		if (!isUsedId(user.getId())) {
			uRepo.insert(user);
			return 1;
		}
		return 0;
	}

	@Override
	public User login(String id, String pass) {
		User user = uRepo.select(id);
		if (user != null && user.getPass().equals(pass)) {
			// t_stamp 에 있는 정보와 user가 가지고 있는 stamp정보 동기화
			List<Stamp> stamps = sRepo.selectByUserId(id);
			if (!stamps.isEmpty()) {
				uRepo.updateStamp(user);
				user.setStampList(stamps);
			}
			return user;
		}

		return null;
	}

	@Override
	public void leave(String id) {
		uRepo.delete(id);
	}

	@Override
	public boolean isUsedId(String id) {

		User user = uRepo.select(id);
		if (user != null && user.getId().equals(id)) {
			return true;
		}
		return false;
	}

	@Override
	public User select(String id) {
		return uRepo.select(id);
	}

	@Transactional
	@Override
	public int insert(User user) {
		return uRepo.insert(user);
	}

	@Transactional
	@Override
	public int update(User user) {
		return uRepo.update(user);
	}

	@Override
	public Map<String, Object> getInfo(String userId) {
		User user = uRepo.select(userId);

		// 해당 유적의 주문 리스트를 받아온다
		List<Order> orders = oRepo.selectByUser(userId);
		
		// 각각 주문에 주문 상세를 넣는다
		for (Order order : orders) {
			List<OrderDetail> orderDetails = odRepo.selectByOrderId(order.getId());
			order.setDetails(orderDetails);
		}
		int stamp = user.getStamps();
		
		Map<String, Object> map = new HashMap<>();
		map.put("orders", orders);
		map.put("stamp", stamp);
		
		return map;
	}

}
