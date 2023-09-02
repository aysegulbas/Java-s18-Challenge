package com.workintech.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="author",schema="spring")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    //iki tarafa bağlanması bi-diretion
    @OneToMany(mappedBy = "author",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Book> bookList;//yazarın birden fazla kitabı olabilir
    //mappedBy'daki authory bookta yazdığımız private Author author'daki author

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public List<Book> getBookList() {
        return bookList;
    }
    public void addBook(Book book){
        if(bookList==null){
            bookList=new ArrayList<>();
        }
        bookList.add(book);
    }
}
