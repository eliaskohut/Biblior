package com.example.biblior.entities;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="newspaper")
public class Newspaper extends Printed{
    @Column(name = "country")
    public String country;
    public Newspaper() {
    }
    @Builder
    public Newspaper(String title, String author, int yearOfPublication, int pages, double feePrice, int quantity, String country) {
        super(title, author, yearOfPublication, pages, feePrice, quantity);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
