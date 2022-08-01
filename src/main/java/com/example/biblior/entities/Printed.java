package com.example.biblior.entities;

import javax.persistence.*;

@Entity
@Table(name="PRINTED")
public abstract class Printed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "TITLE", nullable = false)
    public String title;
    @Column(name = "AUTHOR", nullable = false)
    public String author;
    @Column(name="YEAR_OF_PUBLICATION")
    public int yearOfPublication;
    @Column(name = "PAGES")
    public int pages;
    @Column(name = "FEE_PRICE", nullable = false)
    public double feePrice;
    @Column(name = "QUANTITY", nullable = false)
    public int quantity;
    @Column(name = "BORROWED_BY", nullable = false)
    private Long borrowedBy = 0L;
    private final String printedType = this.getClass().getSimpleName();

    public String getPrintedType() {
        return printedType;
    }

    public Printed() {
    }


    public Printed(String title, String author, int yearOfPublication, int pages, double feePrice, int quantity) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
        this.feePrice = feePrice;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public double getFeePrice() {
        return feePrice;
    }

    public void setFeePrice(double feePrice) {
        this.feePrice = feePrice;
    }

    public Long getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Long borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
