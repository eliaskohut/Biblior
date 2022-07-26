package com.example.biblior.entities;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book extends Printed{
    @Column(name = "genre")
    public String genre;

    public Book() {
    }
    @Builder
    public Book(String title, String author, int yearOfPublication, int pages, double feePrice, int quantity, String genre) {
        super(title, author, yearOfPublication, pages, feePrice, quantity);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
