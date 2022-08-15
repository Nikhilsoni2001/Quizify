package com.nikhil.quizify.controller;

import com.nikhil.quizify.model.exam.Category;
import com.nikhil.quizify.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        this.categoryService.addCategory(category);
        return ResponseEntity.ok(category);
    }

    // get Category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId) {
        return this.categoryService.getCategory(categoryId);
    }

    // get All Categories
    @GetMapping("/")
    public ResponseEntity<Set<Category>> getCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    // update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }

    // delete Category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
    }
}
