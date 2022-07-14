package com.biblior.biblior.entities;

import javax.persistence.*;

@Entity
@Table(name="articles",
uniqueConstraints={
        @UniqueConstraint(name = "cols", columnNames = {"TITLE", "AUTHOR", "YEAR_OF_PUBLISHING", "NUMBER_OF_PAGES"
                , "PRICE", "IS_BORROWED", "FIELD"}
        )
})
public class Article extends Printed{
    @Column(name = "FIELD")
    public String field;
    public Article() {
    }

    public Article(String title, String author, int yearOfPub, int pages, double price, String field) {
        super(title, author, yearOfPub, pages, price);
        this.field = field;
    }
}
