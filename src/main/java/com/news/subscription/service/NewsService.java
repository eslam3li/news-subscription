package com.news.subscription.service;

import java.util.List;

import com.news.subscription.entity.News;;

public interface NewsService {
	
	public List<News> findAll();

	public News findById(Long theId);

	public void save(News theNews);

	public void deleteById(Long theId);
}
