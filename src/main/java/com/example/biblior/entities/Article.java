package com.example.biblior.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Article extends Printed{
    @Column(name="field")
    public String field;

    public Article() {

    }

    public Article(String title, String author, int yearOfPublication, int pages, int feePrice, String field) {
        super(title, author, yearOfPublication, pages, feePrice);
        this.field = field;
    }
}
