package com.example.biblior.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends Printed{
    @Column(name = "genre")
    public String genre;

    public Book() {
    }

    public Book(String title, String author, int yearOfPublication, int pages, int feePrice, String genre) {
        super(title, author, yearOfPublication, pages, feePrice);
        this.genre = genre;
    }
}
