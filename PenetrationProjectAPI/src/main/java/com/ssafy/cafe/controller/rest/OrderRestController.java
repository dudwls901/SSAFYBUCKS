package com.ssafy.cafe.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.OrderDetail;
import com.ssafy.cafe.model.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/order")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
public class OrderRestController {

	@Autowired
	private OrderService oService;

	@PostMapping
	@ApiOperation(value = "order 객체를 저장하고 추가된 Order의 id를 반환한다.", response = Integer.class)
	@Transactional
	public int makeOrder(@RequestBody Map<String, Object> map) {
//		System.out.println(order.getOrderTable());
		System.out.println(map);
		
		return oService.makeOrder(map);
	}

	@GetMapping("/{orderId}")
	@ApiOperation(value = "{orderId}에 해당하는 주문의 상세 내역을 목록 형태로 반환한다."
			+ "이 정보는 사용자 정보 화면의 주문 내역 조회에서 사용된다.", response = List.class)
	public List<Map> getOrderDetail(@PathVariable Integer orderId) {
		return oService.selectOrderTotalInfo(orderId);
	}

	@GetMapping("/byUser")
	@ApiOperation(value = "{id}에 해당하는 사용자의 최근 1개월간 주문 내역을 반환한다."
			+ "반환 정보는 1차 주문번호 내림차순, 2차 주문 상세 내림차순으로 정렬된다.", response = List.class)
	public List<Map<String, Object>> getLastMonthOrder(String id) {
		return oService.getLastMonthOrder(id);
	}

	@GetMapping("")
	@ApiOperation(value = "date에 해당하는 주문 내역을 출력한다.", response = List.class)
	public List<Map<String, Object>> getDayOrder(String date) {
		return oService.getDayOrder(date);
	}
	
	
	@GetMapping("/detail")
	@ApiOperation(value = "모든 주문 상세 리스트를 반환한다.", response = List.class)
	public List<OrderDetail> getAllOrderDetail() {
		return oService.getAllOrderDetail();
	}
	

    @PatchMapping("")
    @ApiOperation(value = "order_id에 해당하는 order의 completed를 Y로 바꾼댜")
    public void changeOrderComplete(@RequestParam("order_id") int order_id) {
    	oService.changeOrderComplete(order_id);
    }
	
}