package com.offers4u.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.category.service.CategoryService;
import com.offers4u.mongodb.domain.Category;

@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}
}