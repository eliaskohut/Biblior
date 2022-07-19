package com.example.biblior.entities;

import javax.persistence.*;

@Entity
@Table(name="printed")
public abstract class Printed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    public String title;
    @Column(name = "author", nullable = false)
    public String author;
    @Column(name="year_of_publication")
    public int yearOfPublication;
    @Column(name = "pages")
    public int pages;
    @Column(name = "fee_price", nullable = false)
    public int feePrice;
    @Column(name = "is_borrowed", nullable = false)
    private boolean isBorrowed = false;

    public Printed() {
    }

    public Printed(String title, String author, int yearOfPublication, int pages, int feePrice) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
        this.feePrice = feePrice;
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

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getFeePrice() {
        return feePrice;
    }

    public void setFeePrice(int feePrice) {
        this.feePrice = feePrice;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
