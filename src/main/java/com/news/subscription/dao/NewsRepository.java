package com.news.subscription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.subscription.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {

}
