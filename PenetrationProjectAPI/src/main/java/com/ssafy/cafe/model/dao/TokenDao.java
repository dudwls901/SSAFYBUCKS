package com.ssafy.cafe.model.dao;

import java.util.List;
import com.ssafy.cafe.model.dto.Token;

public interface TokenDao {
	int insert(Token token);

	String selectByUser(String userId);

	List<Token> selectAll();

	int delete(String userId);
}
