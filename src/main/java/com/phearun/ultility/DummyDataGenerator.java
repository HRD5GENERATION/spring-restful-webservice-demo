/*package com.phearun.ultility;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.phearun.model.Article;
import com.phearun.repository.ArticleRepository;

@Component
@Profile("dummydata")
@Description("Generating dummy data to database")
public class DummyDataGenerator {
	
	@Autowired
	public DummyDataGenerator(ArticleRepository repo) {
		Faker faker = new Faker();
		for(int i=1; i<30; i++){
			Article article = new Article(i, faker.book().title(), faker.lorem().sentence(), faker.internet().image(100, 100, false, "car"));
			repo.save(article);			
		}
	}
	public static void main(String[] args) {
		Faker faker = new Faker();
		for(int i=0; i<30; i++){
			System.out.println("INSERT INTO tbarticle(title, description, thumbnail, category_id) VALUES('" + faker.book().title() + "', '" + faker.lorem().sentence() + "', '" + faker.internet().image(100, 100, false, null) + "', " + (new Random().nextInt(2) + 1) + ");");
		}
	}
}
*/