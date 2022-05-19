package com.ssafy.cafe.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Comment;
import com.ssafy.cafe.model.service.CommentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/comment")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
public class CommentRestController {

	@Autowired
	CommentService cService;

	// 제품에 해당하는 코멘트 리스트 가져옴
	@ApiOperation(value = "해당 제품의 코멘트를 가져온다", response = List.class)
	@GetMapping("/{id}")
	public ResponseEntity<?> searchComments(@PathVariable Integer id) {

		List<Comment> comments = cService.selectByProduct(id);

		if (comments != null && !comments.isEmpty()) {
			return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "새로운 코멘트를 등록한다", response = List.class)
	@PostMapping("")
	public ResponseEntity<?> insertComment(@RequestBody Comment comment) {
		System.out.println(comment);
		cService.addComment(comment);
		List<Comment> comments = cService.selectByProduct(comment.getProductId());
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.CREATED);
	}

	@ApiOperation(value = "코멘트를 수정한다", response = List.class)
	@PutMapping("")
	public ResponseEntity<?> updateComment(@RequestBody Comment comment) {
		System.out.println(comment);
		cService.updateComment(comment);
		List<Comment> comments = cService.selectByProduct(comment.getProductId());
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.CREATED);
	}

	@ApiOperation(value = "코멘트를 삭제한다", response = List.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
		Comment comment = cService.selectComment(id);

		cService.removeComment(id);
		List<Comment> comments = cService.selectByProduct(comment.getProductId());
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.CREATED);
	}
}