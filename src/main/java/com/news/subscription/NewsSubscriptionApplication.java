package com.news.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.news.subscription.dao.CategoryRepository;
import com.news.subscription.dao.UserRepository;

@SpringBootApplication
public class NewsSubscriptionApplication implements ApplicationRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(NewsSubscriptionApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

}
