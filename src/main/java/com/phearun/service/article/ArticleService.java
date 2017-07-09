package com.phearun.service.article;

import java.util.List;

import com.phearun.model.Article;
import com.phearun.model.filter.ArticleFilter;
import com.phearun.ultility.Paging;

public interface ArticleService {

	List<Article> findAll();

	Article findOne(int id);

	boolean remove(int id);

	boolean save(Article article);

	boolean update(Article article);
	
	List<Article> findAllFilter(ArticleFilter filter, Paging paging);
}
