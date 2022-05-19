package com.ssafy.cafe.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShoppingList {
	
	private Integer id;
	private String userId;
	private Integer productId;
	private Integer quantity;
	
	@Builder
	public ShoppingList(Integer id, String user_id, Integer productId, Integer quantity) {
		super();
		this.id = id;
		this.userId = user_id;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public ShoppingList(String user_id, Integer productId, Integer quantity) {
		super();
		this.userId = user_id;
		this.productId = productId;
		this.quantity = quantity;
	}

}
