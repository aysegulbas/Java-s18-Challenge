package com.workintech.bank.service;

import com.workintech.bank.dao.AuthorRepository;
import com.workintech.bank.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorImpl implements Authorservice {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author findById(int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            optionalAuthor.get();
        }
        return null;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
