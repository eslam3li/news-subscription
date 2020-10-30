package com.news.subscription.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.news.subscription.dao.CategoryRepository;
import com.news.subscription.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {

		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long theId) {
		Optional<Category> result = categoryRepository.findById(theId);

		Category theCategory = null;

		if (result.isPresent()) {
			theCategory = result.get();
		} else {
			// throw new TaskNotFoundException("Employee id not found - " + theId);

		}

		return theCategory;
	}

	@Override
	public void save(Category theCategory) {

		categoryRepository.save(theCategory);

	}

	@Override
	public void deleteById(Long theId) {

		categoryRepository.deleteById(theId);

	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		
		
		return 	categoryRepository.findAll(pageable);
	}

}
