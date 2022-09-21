package com.spring.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.lms.model.Blog;


@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {

	
}
