package com.ssafy.cafe.vue.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.vue.dto.User;
import com.ssafy.cafe.vue.service.UserService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/vue")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
@RestController
public class UserRestController {

	private static final int String = 0;
	@Autowired
	private UserService uService;

	
	@ApiOperation(value = "로그인 버튼 클릭시 -> 로그인 할 유저 정보 return: User", response = User.class)
	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println(user);
		User selected = uService.login(user.getId(), user.getPass());

		if (selected != null) {
			Cookie cookie = new Cookie("loginId", 
					URLEncoder.encode(selected.getId(), "utf-8"));

			cookie.setPath("/");
			cookie.setMaxAge(10 * 60);  // 초 단위, 10분
			response.addCookie(cookie);

			return new ResponseEntity<User>(selected, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}
	
	@ApiOperation(value = "로그아웃 버튼 클릭시 -> ", response = User.class)
	@GetMapping("/user/logout")
	public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("loginId")) {

				Cookie removeCookie = new Cookie("loginId", "");
				removeCookie.setPath("/");
				removeCookie.setMaxAge(0);
				response.addCookie(removeCookie);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}

		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}
	
	@ApiOperation(value = "로그인 중인 유저 정보 return: User", response = User.class)
	@GetMapping("/user/me")
	public ResponseEntity<?> me(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				
				String userId = cookie.getValue();
				User selected = uService.select(userId);
				
				return new ResponseEntity<User>(selected, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}
	
	@ApiOperation(value = "회원가입 버튼 클릭시 -> insert user", response = User.class)
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody User user) {
		System.out.println(user);
		int result = uService.join(user);
		if (result > 0) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@ApiOperation(value = "유저의 order정보, stamp정보 응답", response = Map.class)
	@PostMapping("/user/info")
	public ResponseEntity<?> info(@RequestBody User user) {
		String userId = user.getId();
		Map<String, Object> result = uService.getInfo(userId);
		
		// 보내는 데이터 예시
		// orders : 주문 목록, stamp : 유저 스탬프 총 개수
		// {stamp=3, orders=[Order [id=1, userId=id 01, orderTable=order_table 01, orderTime=Sun Mar 27 00:05:33 KST 2022, completed=N, details=[OrderDetail [id=1, orderId=1, productId=1, quantity=1], OrderDetail [id=2, orderId=1, productId=2, quantity=3]]],
		// 					 Order [id=2, userId=id 01, orderTable=order_table 02, orderTime=Sun Mar 27 00:05:33 KST 2022, completed=N, details=[]]]}

		System.out.println(result);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

}
