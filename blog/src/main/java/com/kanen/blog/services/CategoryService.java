package com.kanen.blog.services;

import com.kanen.blog.domain.dtos.CategoryDto;
import com.kanen.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);

}
