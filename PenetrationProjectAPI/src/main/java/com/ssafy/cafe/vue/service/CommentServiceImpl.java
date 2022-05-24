package com.ssafy.cafe.vue.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.service.FirebaseCloudMessageService;
import com.ssafy.cafe.vue.dto.Comment;
import com.ssafy.cafe.vue.dto.OrderDetail;
import com.ssafy.cafe.vue.repo.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo repo;

	@Autowired
	FirebaseCloudMessageService fService;

	@Override
	public void addComment(Comment comment) {
		repo.insert(comment);
		// 관리자에게 메시지 전송
		try {
			fService.sendMessageTo("admin", "코멘트 알림",
					comment.getUserId() + "님의 새로운 코멘트(" + "★" + comment.getRating() + "): " + comment.getComment());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Comment selectComment(Integer id) {
		return repo.select(id);
	}

	@Override
	public void removeComment(Integer id) {
		repo.delete(id);
	}

	@Override
	public void updateComment(Comment comment) {
		repo.update(comment);
	}

	@Override
	public List<Comment> selectByProduct(Integer productId) {

		return repo.selectByProduct(productId);
	}
}
