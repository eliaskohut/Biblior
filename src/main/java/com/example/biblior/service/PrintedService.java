package com.example.biblior.service;

import com.example.biblior.entities.Article;
import com.example.biblior.entities.Book;
import com.example.biblior.entities.Newspaper;
import com.example.biblior.entities.Printed;

import java.util.List;

public interface PrintedService {
    List<Printed> getAllPrinted();
    List<Book> getAllBooks();
    List<Article> getAllArticles();
    List<Newspaper> getAllNewspapers();
    void deletePrinted(Printed printed);
}
