package com.biblior.biblior.entities;

import javax.persistence.*;

@Entity
@Table(name="printed")
public abstract class Printed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="TYPE", nullable = false)
    public String type;
    @Column(name="TITLE", nullable = false)
    public String title;
    @Column(name="AUTHOR", nullable = false)
    public String author;
    @Column(name="YEAR_OF_PUBLISHING")
    public int yearOfPub;
    @Column(name="NUMBER_OF_PAGES")
    public int pages;
    @Column(name="Price")
    public double price;
    @Column(name="IS_BORROWED")
    private boolean isBorrowed = false;

    public Printed() {
    }

    public Printed(String title, String author, int yearOfPub, int pages, double price) {
        this.title = title;
        this.author = author;
        this.yearOfPub = yearOfPub;
        this.pages = pages;
        this.price = price;
        this.type=this.getClass().getSimpleName();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPub() {
        return yearOfPub;
    }

    public void setYearOfPub(int yearOfPub) {
        this.yearOfPub = yearOfPub;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
