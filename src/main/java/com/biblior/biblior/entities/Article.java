package com.biblior.biblior.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Article extends Printed{
    @Column(name = "FIELD")
    public String field=null;
    public Article() {
    }

    public Article(String title, String author, int yearOfPub, int pages, double price, String field) {
        super(title, author, yearOfPub, pages, price);
        this.field = field;
    }
}
