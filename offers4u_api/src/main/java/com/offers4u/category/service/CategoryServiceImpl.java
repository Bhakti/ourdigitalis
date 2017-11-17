package com.offers4u.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.mongodb.domain.Category;
import com.offers4u.mongodb.repository.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {
		System.out.println(categoryRepository.count());
		return categoryRepository.findAll();
	}

}
