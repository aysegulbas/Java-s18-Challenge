package com.workintech.bank.service;

import com.workintech.bank.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    void delete(Category category);
    Category save(Category category);
}
