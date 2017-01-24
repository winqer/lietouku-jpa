package com.winqer.lietouku2.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winqer.lietouku2.common.jwt.AccessToken;
import com.winqer.lietouku2.common.jwt.JwtHelper;
import com.winqer.lietouku2.pojo.User;
import com.winqer.lietouku2.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	@Autowired
	private PostService postRepository;
	
	@RequestMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody User user){
		logger.debug("sigin...");
		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiMSIsInVzZXJuYW1lIjoidGVzdCIsImV4cCI6MTQ3ODIyNTczOCwibmJmIjoxNDc4MjI1Mzc4fQ.dYKkCTf3yUP1uEARCWpbyu2OUnBlEA0uHaTh3C4GJYc";
		AccessToken accessTokenEntity = new AccessToken();
		accessTokenEntity.setAccess_token(token);
		accessTokenEntity.setToken_type("bearer");
		return new ResponseEntity<AccessToken>(accessTokenEntity,HttpStatus.OK);
    }
	
	@RequestMapping("/login")
    public ResponseEntity<?> login(){
		logger.debug("login...");
		
		return new ResponseEntity<String>("{\"message\":\"\",\"success\":true}",HttpStatus.OK);
    }
	
	@RequestMapping("/userInfo")
    public ResponseEntity<?> userInfo(){
		logger.debug("....userInfo");
		return ResponseEntity.ok("{\"username\":\"yang\",\"success\":true,\"message\":\"\"}");
    }
	
	@RequestMapping("/userss")
    public ResponseEntity<?> userss(@RequestBody User user){
		System.out.println("users");
		return ResponseEntity.ok("{\"username\":\"yang\",\"success\":true,\"message\":\"\"}");
    }
    
    @RequestMapping("/login2")
    public ResponseEntity<?> login2(@RequestBody User user){
    	if (user!=null && StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword())) {
    		String token = JwtHelper.createJWT(user.getUsername(), "1", 360000, secretKey);
    		
			return ResponseEntity.ok(token);
		}else {
			System.out.println("user is null");
			return ResponseEntity.badRequest().body("user is null");
		}
    }

}
