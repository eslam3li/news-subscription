package com.news.subscription.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.news.subscription.dao.UserRepository;
import com.news.subscription.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public User findById(Long theId) {
		Optional<User> result = userRepository.findById(theId);

		User theUser = null;

		if (result.isPresent()) {
			theUser = result.get();
		} else {
			// throw new TaskNotFoundException("Employee id not found - " + theId);

		}

		return theUser;
	}

	@Override
	public void save(User theUser) {

		userRepository.save(theUser);

	}

	@Override
	public void deleteById(Long theId) {

		userRepository.deleteById(theId);

	}

}
