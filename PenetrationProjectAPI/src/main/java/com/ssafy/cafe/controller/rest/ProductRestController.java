package com.ssafy.cafe.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Product;
import com.ssafy.cafe.model.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/product")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
public class ProductRestController {

	@Autowired
	ProductService pService;

	@GetMapping()
	@ApiOperation(value = "전체 상품의 목록을 반환한다.", response = List.class)
	public List<Product> getProductList() {
		return pService.getProductList();
	}
	

	@GetMapping("/{productId}")
	@ApiOperation(value = "{productId}에 해당하는 상품의 정보를 반환한다.", response = List.class)
	public Product getProduct(@PathVariable Integer productId) {
		return pService.select(productId);
	}
}