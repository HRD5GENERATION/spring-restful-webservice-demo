package com.phearun.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.phearun.model.Article;
import com.phearun.model.Category;
import com.phearun.repository.provider.CategoryProvider;

@Repository
public interface CategoryRepository {
	
	@Select("SELECT id, name FROM tbcategory")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name")
	})
	List<Category> findAll();
	
	boolean save();
	
	@Select("SELECT id, name FROM tbcategory")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="articles", column="{id=id,name=name}", many=@Many(select="findArticleByCategory"))
	})
	List<Category> findAllCategoryWithArticle();
	
	@SelectProvider(method="findArticleByCategory", type=CategoryProvider.class)
	List<Article> findArticleByCategory(Map<String, Object> params);
	
	
	
	//@Select("SELECT id, title, description, thumbnail FROM tbarticle WHERE category_id=#{id}")
	//List<Article> findArticleByCategory(Integer id);
	
	
	
	
	//@SelectProvider(method="findArticleByCategory", type=CategoryProvider.class)
	//List<Article> findArticleByCategory(Map<String, Object> params /*@Param("id") int id, @Param("name") String name*/);
	
	
}





















