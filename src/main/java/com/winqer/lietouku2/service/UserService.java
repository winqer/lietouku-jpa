package com.winqer.lietouku2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.winqer.lietouku2.pojo.User;

public interface UserService extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {
	

}
