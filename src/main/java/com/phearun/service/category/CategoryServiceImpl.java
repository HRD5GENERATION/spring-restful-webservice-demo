package com.phearun.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phearun.model.Category;
import com.phearun.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

}
