package com.workintech.bank.service;

import com.workintech.bank.entity.Author;

import java.util.List;

public interface Authorservice {
    List<Author> findAll();
    void delete (Author author);
    Author findById(int id);
    Author save(Author author);
}
