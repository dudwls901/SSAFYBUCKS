package com.ssafy.cafe.vue.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.vue.dto.Product;
import com.ssafy.cafe.vue.dto.Stamp;
import com.ssafy.cafe.vue.repo.CommentRepo;
import com.ssafy.cafe.vue.repo.ProductRepo;
import com.ssafy.cafe.vue.repo.StampRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo pRepo;
	
	@Autowired
	private StampRepo sRepo;
	
	@Autowired
	private CommentRepo cRepo;
	
	@Override
	public List<Product> getProductList() {
		
		return pRepo.selectAll();
	}

	@Override
	public Product selectWithComment(Integer productId) {
		
		return pRepo.select(productId);
	}

}
