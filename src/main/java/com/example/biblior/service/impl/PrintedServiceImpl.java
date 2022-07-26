package com.example.biblior.service.impl;

import com.example.biblior.entities.Article;
import com.example.biblior.entities.Book;
import com.example.biblior.entities.Newspaper;
import com.example.biblior.entities.Printed;
import com.example.biblior.repositories.PrintedRepository;
import com.example.biblior.service.PrintedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintedServiceImpl implements PrintedService {
    private PrintedRepository printedRepository;

    public PrintedServiceImpl(PrintedRepository printedRepository) {
        super();
        this.printedRepository = printedRepository;
    }

    @Override
    public List<Printed> getAllPrinted() {
        return printedRepository.findAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) printedRepository.findByPrintedTypeContaining("Book");
    }

    @Override
    public List<Article> getAllArticles() {
        return (List<Article>) printedRepository.findByPrintedTypeContaining("Article");
    }

    @Override
    public List<Newspaper> getAllNewspapers() {
        return (List<Newspaper>) printedRepository.findByPrintedTypeContaining("Newspaper");
    }
}
