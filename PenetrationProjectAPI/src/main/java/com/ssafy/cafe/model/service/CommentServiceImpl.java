package com.ssafy.cafe.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.cafe.model.dao.CommentDao;
import com.ssafy.cafe.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao cDao;

	@Autowired
	FirebaseCloudMessageService fService;

	@Override
	@Transactional
	public void addComment(Comment comment) {
		cDao.insert(comment);
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
	@Transactional
	public void removeComment(Integer commentId) {
		cDao.delete(commentId);

	}

	@Override
	@Transactional
	public void updateComment(Comment comment) {
		cDao.update(comment);
	}

	@Override
	public List<Comment> selectByProduct(Integer productId) {
		return cDao.selectByProduct(productId);
	}

	@Override
	public Comment selectComment(Integer id) {
		return cDao.select(id);
	}

	@Override
	public List<Comment> selectAll() {
		return cDao.selectAll();
	}

}
