package com.organimaster.org.controller;

import com.organimaster.org.model.Category;
import com.organimaster.org.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    public List<Category> getCategories() {
        return categoryService.spGetCategories();
    }

    @PostMapping("/api/categories")
    public int addCategory(@RequestBody String categoryName) {
        return categoryService.insertSpCategory(categoryName);
    }
}
