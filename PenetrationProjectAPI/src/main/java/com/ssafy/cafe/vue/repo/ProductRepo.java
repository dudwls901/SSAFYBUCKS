package com.ssafy.cafe.vue.repo;

import java.util.List;
import java.util.Map;

import com.ssafy.cafe.vue.dto.Product;

public interface ProductRepo {
    int insert(Product product);

    int update(Product product);

    int delete(Integer productId);

    Product select(Integer productId);

    List<Product> selectAll();
}
