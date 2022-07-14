package com.biblior.biblior.entities;

import javax.persistence.*;

@Entity
@Table(name="books",
        uniqueConstraints={
                @UniqueConstraint(name = "cols", columnNames = {"TITLE", "AUTHOR", "YEAR_OF_PUBLISHING", "NUMBER_OF_PAGES"
                        , "PRICE", "IS_BORROWED", "GENRE"}
                )
        })
public class Book extends Printed {
    @Column(name = "GENRE")
    public Genres genre;
    public Book() {
    }

    public Book(String title, String author, int yearOfPub, int pages, double price, Genres genre) {
        super(title, author, yearOfPub, pages, price);
        this.genre = genre;
    }
}
