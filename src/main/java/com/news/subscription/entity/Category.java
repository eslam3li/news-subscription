package com.news.subscription.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name",unique = true)
	private String name;
	@Column(name = "icon_url")
	private String iconUrl;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade = { CascadeType.PERSIST,
//						CascadeType.MERGE,
//						CascadeType.DETACH,
//						CascadeType.REFRESH })
//	@JoinTable(name = "subscribed_categories",
//			joinColumns =@JoinColumn(name = "category_id"),
//			inverseJoinColumns =@JoinColumn(name = "user_id"))
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
    private Set<User> users;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private List<News> news;
	
	public void addNews(News news) {
		
		if (this.news == null) {
			
			this.news = new ArrayList<>();
			
		}
		this.news.add(news);
	}
	
	public void addUsers(User user) {
		
		if (this.users == null) {
			
			this.users = new HashSet<>();
			
		}
		this.users.add(user);
	}
	

}

