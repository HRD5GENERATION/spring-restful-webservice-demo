package com.phearun.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phearun.model.Article;
import com.phearun.model.filter.ArticleFilter;
import com.phearun.service.article.ArticleService;
import com.phearun.ultility.Paging;

@RestController
@RequestMapping("/api/v1")
public class ArticleRestController {

	private ArticleService articleService;
	
	@Autowired
	public ArticleRestController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping("/articles")
	public Map<String, Object> findAll(ArticleFilter filter, Paging paging){
		List<Article> articles = articleService.findAllFilter(filter, paging);
		
		Map<String, Object> response = new HashMap<>();
		
		if(!articles.isEmpty()){
			response.put("message", "Success!");
			response.put("status", true);
			response.put("data", articles);
			response.put("paging", paging);
		}else{
			response.put("message", "No article!");
			response.put("status", false);
		}
		return response;
	}
	
	@PostMapping("/articles")
	public boolean save(@RequestBody Article article){
		System.out.println(article);
		return articleService.save(article);
	}
	
	@GetMapping("/articles/{id}")
	public Article findOne(@PathVariable("id") Integer id){
		System.out.println(id);
		return articleService.findOne(id);
	}
	
	@PutMapping("/articles")
	public boolean update(@RequestBody Article article){
		System.out.println(article);
		return articleService.update(article);
	}
	
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Integer id){
		System.out.println(id);
		Map<String, Object> response = new HashMap<>();
		if(articleService.remove(id)){
			response.put("message", "Removed Successfully!");
			response.put("status", true);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
	}
	
}
