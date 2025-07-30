package com.kanen.blog.controllers;

import com.kanen.blog.domain.dtos.CategoryDto;
import com.kanen.blog.domain.entities.Category;
import com.kanen.blog.domain.entities.Post;
import com.kanen.blog.mappers.CategoryMapper;
import com.kanen.blog.repositories.CategoryRepository;
import com.kanen.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<CategoryDto> categories = categoryService.listCategories()
                .stream().map(categoryMapper::toDto)
                .toList();

        return ResponseEntity.ok(categories);

    }
}
