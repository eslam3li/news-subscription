package com.news.subscription.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.news.subscription.entity.Category;

public interface CategoryService {
	
	public List<Category> findAll();
	
	public Page<Category> findAll(Pageable pageable);

	public Category findById(Long theId);

	public void save(Category theCategory);

	public void deleteById(Long theId);
}
