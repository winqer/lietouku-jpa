package com.winqer.lietouku2.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winqer.lietouku2.pojo.Post;

public interface PostService extends JpaRepository<Post, Integer> {

}
