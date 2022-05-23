package com.ssafy.cafe.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.vue.dto.Stamp;
import com.ssafy.cafe.vue.repo.StampRepo;

@Service
public class StampServiceImpl implements StampService {

	@Autowired
	private StampRepo repo;

	@Override
	public List<Stamp> selectByUser(String id) {
		return repo.selectByUserId(id);
	}

}
