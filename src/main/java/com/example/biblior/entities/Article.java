package com.example.biblior.entities;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article extends Printed{
    @Column(name="field")
    public String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Article() {

    }
    @Builder
    public Article(String title, String author, int yearOfPublication, int pages, double feePrice, int quantity, String field) {
        super(title, author, yearOfPublication, pages, feePrice, quantity);
        this.field = field;
    }
}
