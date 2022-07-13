package com.biblior.biblior.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Book extends Printed {
    @Column(name = "genre")
    public Genres genre;
    public Book() {
    }

    public Book(String title, String author, int yearOfPub, int pages, double price, Genres genre) {
        super(title, author, yearOfPub, pages, price);
        this.genre = genre;
    }
}
