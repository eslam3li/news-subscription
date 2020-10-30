package com.news.subscription.entity;

import javax.persistence.*;

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
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "headline")
	private String headline;
	@Column(name = "article")
	private String article;
	@Column(name = "imageURL")
	private String imageURL;
	
}

