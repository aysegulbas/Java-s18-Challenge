package com.workintech.bank.controller;

import com.workintech.bank.entity.Author;
import com.workintech.bank.entity.Book;
import com.workintech.bank.mapping.AuthorResponse;
import com.workintech.bank.mapping.BookResponse;
import com.workintech.bank.service.Authorservice;
import com.workintech.bank.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private Authorservice authorservice;
    private BookService bookService;

    @Autowired
    public AuthorController(Authorservice authorservice, BookService bookService) {
        this.authorservice = authorservice;
        this.bookService = bookService;
    }


    @GetMapping("/")
    public List<AuthorResponse> findAll() {
        List<Author> authors = authorservice.findAll();
        List<AuthorResponse> authorResponses = new ArrayList<>();
        for (Author author : authors) {
            List<BookResponse> bookResponses = new ArrayList<>();
            for (Book book : author.getBookList()) {
                bookResponses.add(new BookResponse(book.getId(), book.getName(), book.getCategory().getName()
                ));
            }
            authorResponses.add(new AuthorResponse(author.getId(), author.getFirst_name(), author.getLast_name(), bookResponses));
        }
        return authorResponses;
    }

    @PostMapping("/")
    public AuthorResponse save(@RequestBody Author author) {
        Author savedAuthor = authorservice.save(author);
        return new AuthorResponse(savedAuthor.getId(), savedAuthor.getFirst_name(), savedAuthor.getLast_name(), null);
    }

    @PostMapping("/{bookId}")
    public AuthorResponse save(@RequestBody Author author, @PathVariable int bookId) {
        Book book = bookService.findById(bookId);
        author.addBook(book);
        book.setAuthor(author);//yazara kitabı eklediğimiz gibi kitaba da yazarı eklememiz lazım
        authorservice.save(author);
        return new AuthorResponse(author.getId(), author.getFirst_name(), author.getLast_name(), null);//null yerine finAll'daki gibi bookresponses yapılabilirdi
    }

}
