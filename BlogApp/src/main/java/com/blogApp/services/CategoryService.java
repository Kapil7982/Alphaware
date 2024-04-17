package com.blogApp.services;

import java.util.List;

import com.blogApp.models.Category;

public interface CategoryService {

	public List<Category> getAllCategories();
	public Category getCategoryById(Long id);
	public Category createCategory(Category category);
	public Category updateCategory(Long id, Category category);
	public void deleteCategory(Long id);
}
