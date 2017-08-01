package com.phearun.repository.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider {
	
	
	public String findArticleByCategory(Map<String, Object> params){
		System.out.println("params: " + params);
		return new SQL(){{
			SELECT("id, title, description, thumbnail")
			.FROM("tbarticle")
			.WHERE("category_id=#{id}");
		}}.toString();
	}
	
	//public String findArticleByCategory(Map<String, Object> params /*@Param("id") int id, @Param("name") String name*/){
	//	System.out.println("params: " + params/*id + name*/);
	//	return "SELECT id, title, description, thumbnail FROM tbarticle WHERE category_id=#{id}";// + id;
	//}
	
}
