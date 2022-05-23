package com.ssafy.cafe.vue.repo;

import java.util.List;

import com.ssafy.cafe.vue.dto.Comment;


public interface CommentRepo {
    int insert(Comment comment);

    int update(Comment comment);

    int delete(Integer commentId);

    Comment select(Integer commentId);

    List<Comment> selectAll();

    List<Comment> selectByProduct(Integer productId);
}
