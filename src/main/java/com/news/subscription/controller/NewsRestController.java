package com.news.subscription.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.subscription.entity.Category;
import com.news.subscription.entity.User;
import com.news.subscription.service.CategoryService;
import com.news.subscription.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/news")
public class NewsRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	// News Types Retrieval
	@GetMapping("/types")
	public ResponseEntity<Map<String, Object>> getAllTypes(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {

		Map<String, Object> response = null;
		try {
			List<Category> categories = new ArrayList<Category>();
			Pageable paging = PageRequest.of(page, size);

			Page<Category> pageCategories = categoryService.findAll(paging);
			categories = pageCategories.getContent();

			response = new HashMap<>();
			response.put("NewsCategories", categories);
			response.put("currentPage", pageCategories.getNumber());
			response.put("totalItems", pageCategories.getTotalElements());
			response.put("totalPages", pageCategories.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = new HashMap<>();
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", "INTERNAL_SERVER_ERROR");
			response.put("timeStamp", System.currentTimeMillis());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Subscribed News Type(s) Retrieval
	@GetMapping("/subscribed/{userId}")
	public ResponseEntity<Map<String, Object>> getSubscribedNews(@PathVariable Long userId) {

		Map<String, Object> response;
		try {
			User theUser = userService.findById(userId);
			response = new HashMap<>();
			// response.put("user", theUser);
			response.put("subscribedCategories", theUser.getCategories());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = new HashMap<>();
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.put("message", "INTERNAL_SERVER_ERROR");
			response.put("timeStamp", System.currentTimeMillis());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Adds news type subscription to the requesting user
	@PostMapping("/subscribe")
	public void subscribe(@RequestBody User user) {
		User theUser = userService.findById(user.getId());
		user.getCategories().stream().forEach(catg -> theUser.addCategory(catg));
		userService.save(theUser);
	}

	// Removes news type subscription to the requesting user.
	@DeleteMapping("/unsubscribe/{categoryId}")
	public String unsubscribe(@RequestBody User user, @PathVariable Long categoryId) {

		User theUser = userService.findById(user.getId());
		Set<Category> subscribedCategories = theUser.getCategories().stream().filter(type -> type.getId() != categoryId)
				.collect(Collectors.toSet());
		theUser.setCategories(subscribedCategories);
		userService.save(theUser);
		return "Deleted Type id - " + categoryId;
	}
}
