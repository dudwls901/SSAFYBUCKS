package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.ShoppingList;

public interface ShoppingListDao {

	int insert(ShoppingList shoppingList);

	int update(ShoppingList shoppingList);

	int deleteByUser(String userId);
	
	int deleteOne(ShoppingList shoppingList);

	ShoppingList select(ShoppingList shoppingList);

	List<ShoppingList> selectAll();

	List<ShoppingList> selectByUser(String userId);
	
}
