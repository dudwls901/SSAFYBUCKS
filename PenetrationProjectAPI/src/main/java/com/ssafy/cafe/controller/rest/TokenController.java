package com.ssafy.cafe.controller.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Token;
import com.ssafy.cafe.model.service.FirebaseCloudMessageService;

@RestController
@RequestMapping("/rest/token")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
public class TokenController {
	

    @Autowired
    FirebaseCloudMessageService service;
    
    // 고객의 토큰 정보 받음
    @PostMapping("")
    public String registToken(String userId,String token) {
    	Token t = new Token(userId,token);
        service.addToken(t);
    	System.out.println(token);
        return token;
    }
    
    // 모든 고객에게 메시지 전송
    @PostMapping("/broadcast")
    public Integer broadCast(String title, String body) throws IOException {
    	return service.broadCastMessage(title, body);
    }

    // 특정 토큰을 가진 고객에게 메시지 전송
    @PostMapping("/sendMessageTo")
    public void sendMessageTo(String userId, String title, String body) throws IOException {
        service.sendMessageTo(userId, title, body);
    }
    
    // 주문할때 점주에게 메시지 전송
    
    // 음료 준비되면 고객한테 메시지 전송
}