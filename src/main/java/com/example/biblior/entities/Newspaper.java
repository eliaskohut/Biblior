package com.example.biblior.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Newspaper extends Printed{
    @Column(name = "country")
    public String country;

    public Newspaper() {
    }

    public Newspaper(String title, String author, int yearOfPublication, int pages, int feePrice, String country) {
        super(title, author, yearOfPublication, pages, feePrice);
        this.country = country;
    }
}
