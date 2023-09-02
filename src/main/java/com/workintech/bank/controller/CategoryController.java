package com.workintech.bank.controller;

import com.workintech.bank.entity.Category;
import com.workintech.bank.service.BookService;
import com.workintech.bank.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> findAll() {
        return categoryService.findAll();

    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Category delete(@PathVariable int id) {
        Category foundCategory = getById(id);
        if(foundCategory!=null){
        categoryService.delete(foundCategory);
        return foundCategory;
        }return null;
    }

    @PostMapping("/")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }
    @PutMapping("/{id}")
    public Category update(@RequestBody Category category, @PathVariable int id){
        Category foundCategory=getById(id);
        if(foundCategory!=null){
            category.setId(id);//set metotta içine Id verirsen update yapar, vermezsen insert yapar
            return categoryService.save(category);
        }return null;

    }

}
