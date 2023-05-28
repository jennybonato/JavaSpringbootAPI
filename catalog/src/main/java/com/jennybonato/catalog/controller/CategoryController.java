package com.jennybonato.catalog.controller;

import com.jennybonato.catalog.model.Category;
import com.jennybonato.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> get(){
        return categoryService.get();
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id){
        Category category = categoryService.get(id);
        if(category == null) {
            throw new RuntimeException("Category with id " + id + " was not found");
        }
        return category;
    }

    @PostMapping("")
    public Category create(@RequestBody Category category){
        categoryService.save(category);
        return category;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        categoryService.delete(id);
        return "Category has beed deleted with id " + id;
    }

    @PutMapping("")
    public Category update(@RequestBody Category category){
        categoryService.save(category);
        return category;
    }
}
