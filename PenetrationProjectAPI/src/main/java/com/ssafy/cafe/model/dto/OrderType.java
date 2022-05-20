package com.ssafy.cafe.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderType {
	
	private Integer orderId;
	private String type;
	
	@Builder
	public OrderType(Integer order_id, String type) {
		super();
		this.orderId = order_id;
		this.type = type;
	}
	

}
