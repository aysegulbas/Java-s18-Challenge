package com.workintech.bank.controller;

import com.workintech.bank.dao.BookRepository;
import com.workintech.bank.entity.Author;
import com.workintech.bank.entity.Book;
import com.workintech.bank.entity.Category;
import com.workintech.bank.mapping.BookResponse;
import com.workintech.bank.service.Authorservice;
import com.workintech.bank.service.BookService;
import com.workintech.bank.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private CategoryService categoryService;
    private Authorservice authorservice;
    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, Authorservice authorservice) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorservice = authorservice;
    }




    @GetMapping("/")
    public List<BookResponse> findAll() {
        List<Book> books = bookService.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book book : books) {
            bookResponses.add(new BookResponse(book.getId(), book.getName(), book.getCategory().getName()));
        }
        return bookResponses;
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable int id) {
        Book book = bookService.findById(id);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName());
    }

    @PutMapping("/{id}")
    public BookResponse update(@RequestBody Book book, @PathVariable int id) {
        Book foundBook = bookService.findById(id);
        if (foundBook != null) {
            book.setAuthor(foundBook.getAuthor());//authoru kaybetmeyelim diye
            book.setCategory(foundBook.getCategory());//Category kaybetmeyelim diye, sadece kitabın adını değiştirmeye çalışıyoruz
            book.setId(id);
            bookService.save(book);
            return new BookResponse(book.getId(), book.getName(), book.getCategory().getName());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public BookResponse delete(@PathVariable int id) {
        Book book = bookService.findById(id);
        if (book != null) {
            bookService.delete(book);
            return new BookResponse(book.getId(), book.getName(), book.getCategory().getName());
        }
        return null;

    }

    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable int categoryId) {
//önce id'den categoryi bulmamız lazım,categoryservicei çağırmamız lazım yukarda
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            book.setCategory(category);
            bookService.save(book);
            return new BookResponse(book.getId(), book.getName(), category.getName());
        }
        return null;
    }

    @PostMapping("saveByAuthor/{categoryId}/{authorId}")
    public BookResponse saveByAuthor(@RequestBody Book book, @PathVariable int categoryId, @PathVariable int authorId) {
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            book.setCategory(category);
            Author author=authorservice.findById(authorId);
            if(author!=null){
                book.setAuthor(author);
                Book savedBook=bookService.save(book);
                return new BookResponse(savedBook.getId(),savedBook.getName(),savedBook.getCategory().getName(),savedBook.getAuthor().getFirst_name(),savedBook.getAuthor().getLast_name());
            }return null;
        }return null;
    }
}
