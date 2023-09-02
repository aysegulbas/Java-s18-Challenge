package com.workintech.bank.service;

import com.workintech.bank.dao.CategoryRepository;
import com.workintech.bank.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService{
private CategoryRepository categoryRepository;
@Autowired
    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }
        return null;
    }

    @Override
    public void delete(Category category) {
categoryRepository.delete(category);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
