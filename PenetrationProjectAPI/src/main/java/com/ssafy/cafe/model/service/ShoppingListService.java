package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.cafe.model.dto.ShoppingList;

public interface ShoppingListService {

	public List<Map<String, Object>> add(Map<String, Object> map);

	public List<Map<String, Object>> update(ShoppingList shoppingList);

	public List<Map<String, Object>> removeByUser(String userId);

	public List<Map<String, Object>> removeOne(Map<String, Object> map);

	public List<Map<String, Object>> selectByUser(String userId);

}
