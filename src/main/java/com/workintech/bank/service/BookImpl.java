package com.workintech.bank.service;

import com.workintech.bank.dao.BookRepository;
import com.workintech.bank.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImpl implements BookService{
    private BookRepository bookRepository;
@Autowired
    public BookImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Book book) {
bookRepository.delete(book);

    }

    @Override
    public Book findById(int id) {
        Optional<Book>optionalBook=bookRepository.findById(id);
        if(optionalBook.isPresent()){
return optionalBook.get();
        }return null;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
