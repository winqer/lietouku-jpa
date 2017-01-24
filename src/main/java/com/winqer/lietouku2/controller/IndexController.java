package com.winqer.lietouku2.controller;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winqer.lietouku2.pojo.User;
import com.winqer.lietouku2.service.UserService;

import io.jsonwebtoken.Claims;

@RestController
public class IndexController {
	
	@Autowired
	private UserService userRepository;

    @RequestMapping("/")
    String home() {
        return "Hello World!-1";
    }
    
    @RequestMapping("/post")
    public User post(final HttpServletRequest request){
    	final Claims claims = (Claims) request.getAttribute("claims");
    	System.out.println("claims:"+claims.get("username"));
    	return userRepository.findOne(1);
    }
    
    @RequestMapping("/user")
    public Page<User> search(@RequestBody User user) {
        return userRepository.findAll(user, new PageRequest(0, 10, new Sort(Direction.ASC, "id")));
   }

}
