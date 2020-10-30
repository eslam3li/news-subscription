package com.news.subscription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.subscription.entity.Category;;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
