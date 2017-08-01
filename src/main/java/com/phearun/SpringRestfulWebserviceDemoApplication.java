package com.phearun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.phearun.repository.CategoryRepository;

@SpringBootApplication
public class SpringRestfulWebserviceDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestfulWebserviceDemoApplication.class, args);
		CategoryRepository repo = context.getBean(CategoryRepository.class);
		repo.findAllCategoryWithArticle().forEach(System.out::println);
		
	}
}
