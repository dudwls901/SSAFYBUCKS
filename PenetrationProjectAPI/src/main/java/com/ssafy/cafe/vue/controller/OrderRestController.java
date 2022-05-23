package com.ssafy.cafe.vue.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.vue.dto.Order;
import com.ssafy.cafe.vue.dto.OrderDetail;
import com.ssafy.cafe.vue.dto.User;
import com.ssafy.cafe.vue.service.OrderService;
import com.ssafy.cafe.vue.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/vue")
@CrossOrigin(allowCredentials = "true", originPatterns = { "*" })
@RestController
@Api(value = "Order")
public class OrderRestController {
    
    @Autowired
    private OrderService oService;
    
    
    @Autowired
    private UserService uService;
    
    @ApiOperation(value = "주문하기")
    @PostMapping("/order")
    public ResponseEntity<?> doOrder(@RequestBody Map<String,Object> oderInfo) {
    	System.out.println(oderInfo);
        oService.makeOrder(oderInfo);
        
        return new ResponseEntity<Integer>(1,HttpStatus.OK);
    }
   
    
    
}