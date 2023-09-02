package com.workintech.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="category",schema = "spring")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "category",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Book>bookList;//bir kategoryde birden fazla kitap olacağı için çoğul
}
