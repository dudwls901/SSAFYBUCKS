package com.ssafy.cafe.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.cafe.model.dao.ProductDao;
import com.ssafy.cafe.model.dao.ShoppingListDao;
import com.ssafy.cafe.model.dto.Product;
import com.ssafy.cafe.model.dto.ShoppingList;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

	@Autowired
	ShoppingListDao slDao;

	@Autowired
	ProductDao pDao;

	@Override
	@Transactional
	public List<Map<String, Object>> add(Map<String, Object> map) {

		String userId = (String) map.get("userId");
		String type = (String) map.get("type");

		if (type != null && type.equals("list")) {
			List<Map<String, Object>> orderProductList = (List<Map<String, Object>>) map.get("orderProductList");

			for (Map<String, Object> orderProduct : orderProductList) {
				Map<String, Object> productMap = (Map<String, Object>) orderProduct.get("product");
				Product product = new Product((Integer) productMap.get("id"), (String) productMap.get("name"),
						(String) productMap.get("type"), (Integer) productMap.get("price"),
						(String) productMap.get("img"));
				int quantity = (int) orderProduct.get("quantity");
				ShoppingList shoppingList = new ShoppingList(userId, product.getId(), quantity);

				ShoppingList preShoppingList = slDao.select(shoppingList);
				if (preShoppingList == null) {
					slDao.insert(shoppingList);
				} else {
					shoppingList.setQuantity(shoppingList.getQuantity() + preShoppingList.getQuantity());
					slDao.update(shoppingList);
				}
			}

		} else {
			Integer productId = (Integer) ((Map<String,Object>) map.get("product")).get("id");
			int quantity = (int) map.get("quantity");
			ShoppingList shoppingList = new ShoppingList(userId, productId, quantity);

			ShoppingList preShoppingList = slDao.select(shoppingList);
			if (preShoppingList == null) {
				slDao.insert(shoppingList);
			} else {
				shoppingList.setQuantity(shoppingList.getQuantity() + preShoppingList.getQuantity());
				slDao.update(shoppingList);
			}

		}

		return selectByUser(userId);
	}

	@Override
	@Transactional
	public List<Map<String, Object>> update(ShoppingList shoppingList) {

		slDao.update(shoppingList);
		return selectByUser(shoppingList.getUserId());
	}

	@Override
	@Transactional
	public List<Map<String, Object>> removeByUser(String userId) {

		slDao.deleteByUser(userId);
		return selectByUser(userId);
	}

	@Override
	@Transactional
	public List<Map<String, Object>> removeOne(Map<String, Object> map) {
		String userId = (String) map.get("userId");
		Integer productId = (Integer) map.get("productId");

		ShoppingList shoppingList = new ShoppingList(userId, productId);

		slDao.deleteOne(shoppingList);
		return selectByUser(userId);
	}

	@Override
	@Transactional
	public List<Map<String, Object>> selectByUser(String userId) {
		List<ShoppingList> list = slDao.selectByUser(userId);

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (ShoppingList s : list) {
			Map<String, Object> map = new HashMap<String, Object>();

			Product product = pDao.select(s.getProductId());

			map.put("product", product);
			map.put("quantity", s.getQuantity());
			result.add(map);
		}

		System.out.println(result);
		return result;
	}

}
