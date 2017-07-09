package com.phearun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Category {
	
	@XmlElement(name="id")
	private int id;
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="articles")
	private List<Article> articles;
	
	public Category(){}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", articles=" + articles + "]";
	}
}
