package com.ssafy.cafe.vue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.vue.dto.Comment;
import com.ssafy.cafe.vue.dto.OrderDetail;
import com.ssafy.cafe.vue.dto.Product;
import com.ssafy.cafe.vue.service.CommentService;
import com.ssafy.cafe.vue.service.OrderService;
import com.ssafy.cafe.vue.service.ProductService;
import com.ssafy.cafe.vue.service.StampService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/vue")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
@RestController
@Api(value = "Product")
public class ProductRestController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private CommentService cService;
	
	// 전체 ProductList를 가져옴
	@ApiOperation(value = "전체 제품 정보를 가져온다", response = List.class)
	@GetMapping("/product")
	public ResponseEntity<?> searchProducts() {
		
		List<Product> products = pService.getProductList();
		
		if (products != null && !products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	// 상품별 정보조회
	@ApiOperation(value = "제품 상세 정보를 보여준다", response = Map.class)
	@GetMapping("/product/{id}")
	public ResponseEntity<?> selectProductDetail(@PathVariable Integer id) {
		
		Map<String,Object> result = new HashMap<String, Object>();

		// 제품 정보 가져옴
		Product product = pService.selectWithComment(id);
		result.put("product", product);
		
		// 총 주문 개수 가져옴
		List<OrderDetail> odList = oService.selectOrderTotalInfo(id);
		
		int totalOrder = 0;
		for(OrderDetail item : odList) {
			totalOrder += item.getQuantity();
		}
		result.put("totalOrder", totalOrder);
		
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}
}
