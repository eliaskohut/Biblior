package com.biblior.biblior.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Newspaper extends Printed{
    @Column(name = "country")
    public String country;
    public Newspaper() {
    }

    public Newspaper(String title, String author, int yearOfPub, int pages, double price, String country) {
        super(title, author, yearOfPub, pages, price);
        this.country = country;
    }
}
