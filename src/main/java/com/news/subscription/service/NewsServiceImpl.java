package com.news.subscription.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.subscription.dao.NewsRepository;
import com.news.subscription.entity.News;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Override
	public List<News> findAll() {

		return newsRepository.findAll();
	}

	@Override
	public News findById(Long theId) {
		Optional<News> result = newsRepository.findById(theId);

		News theNews = null;

		if (result.isPresent()) {
			theNews = result.get();
		} else {
			// throw new TaskNotFoundException("Employee id not found - " + theId);

		}

		return theNews;
	}

	@Override
	public void save(News theNews) {

		newsRepository.save(theNews);

	}

	@Override
	public void deleteById(Long theId) {

		newsRepository.deleteById(theId);

	}

}
