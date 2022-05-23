package com.ssafy.cafe.vue.repo;

import java.util.List;

import com.ssafy.cafe.vue.dto.Stamp;

public interface StampRepo {
    int insert(Stamp stamp);

    Stamp select(Integer stampId);

    List<Stamp> selectAll();
    
    List<Stamp> selectByUserId(String userId);
    
    List<Stamp> selectByProductId(String productId);
}
