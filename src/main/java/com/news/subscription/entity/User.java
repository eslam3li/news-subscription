package com.news.subscription.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name",unique=true)
	private String name;
	@Column(name = "email",unique=true)
	private String email;
	@Column(name = "password")
	private String password;

	//@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = { CascadeType.PERSIST,
							CascadeType.MERGE,
							CascadeType.DETACH,
							CascadeType.REFRESH })
	@JoinTable(name = "subscribed_categories",
				joinColumns =@JoinColumn(name = "user_id"),
				inverseJoinColumns =@JoinColumn(name = "category_id"))
	private Set<Category> categories;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public void addCategory(Category category) {
		if (categories == null) {
			categories = new HashSet<>();
		}
		categories.add(category);
	}


}
