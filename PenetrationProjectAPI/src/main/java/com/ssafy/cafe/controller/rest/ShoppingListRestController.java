package com.ssafy.cafe.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Product;
import com.ssafy.cafe.model.dto.ShoppingList;
import com.ssafy.cafe.model.service.ShoppingListService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/shopping_list")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
public class ShoppingListRestController {

	@Autowired
	private ShoppingListService slService;

	@PostMapping("/add")
	@ApiOperation(value = "해당 유저의 장바구니를 추가한다.", response = Map.class)
	public List<Map<String, Object>> add(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		return slService.add(map);
	}

	@GetMapping("/{userId}")
	@ApiOperation(value = "해당 유저의 장바구니 리스트를 반환한다.", response = Map.class)
	public List<Map<String, Object>> selectByUser(@PathVariable String userId) {
		return slService.selectByUser(userId);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "해당 유저의 특정 제품 장바구니를 삭제한다.", response = Map.class)
	public List<Map<String, Object>> removeOne(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		return slService.removeOne(map);
	}

	@DeleteMapping("/{userId}")
	@ApiOperation(value = "해당 유저의 특정 제품 장바구니를 삭제한다.", response = Map.class)
	public List<Map<String, Object>> removeByUser(@PathVariable String userId) {
		System.out.println(userId);
		return slService.removeByUser(userId);
	}
}
