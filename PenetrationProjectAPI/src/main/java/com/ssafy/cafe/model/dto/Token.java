package com.ssafy.cafe.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Token {
	
	private String userId;
	private String token;
	
	@Builder
	public Token(String userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}
}
