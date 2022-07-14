package com.biblior.biblior.entities;

import javax.persistence.*;

@Entity
@Table(name="articles",
        uniqueConstraints={
                @UniqueConstraint(name = "cols", columnNames = {"TITLE", "AUTHOR", "YEAR_OF_PUBLISHING", "NUMBER_OF_PAGES"
                        , "PRICE", "IS_BORROWED", "COUNTRY"}
                )
        })
public class Newspaper extends Printed{
    @Column(name = "COUNTRY")
    public String country=null;
    public Newspaper() {
    }

    public Newspaper(String title, String author, int yearOfPub, int pages, double price) {
        super(title, author, yearOfPub, pages, price);
    }

    public Newspaper(String title, String author, int yearOfPub, int pages, double price, String country) {
        super(title, author, yearOfPub, pages, price);
        this.country = country;
    }

}
