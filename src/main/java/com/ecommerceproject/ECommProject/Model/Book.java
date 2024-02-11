package com.ecommerceproject.ECommProject.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String bookName, Author author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Book() {

    }
}
