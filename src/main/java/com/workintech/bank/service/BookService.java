package com.workintech.bank.service;

import com.workintech.bank.entity.Book;

import java.util.List;

public interface BookService{
    List<Book> findAll();
    void delete (Book book);
    Book findById(int id);
    Book save(Book book);

}
