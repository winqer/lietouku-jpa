package com.winqer.lietouku2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winqer.lietouku2.common.Page;
import com.winqer.lietouku2.pojo.User;
import com.winqer.lietouku2.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<?> get(){
		User user = new User();
		user.setUsername("yangwq");
		user.setPassword("12345");
		List<User> users = new ArrayList<>();
		users.add(user);
		
		Page p = new Page();
		p.setPage(1);
		p.setTotal(10);
		p.setCurrent(2);
	
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", users);
		resMap.put("page", p);
		
		return new ResponseEntity<Map<String, Object>>(resMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<?> post(){
		
		return new ResponseEntity<String>("post", HttpStatus.OK);
	}
}
