package com.biblior.biblior;

import com.biblior.biblior.entities.*;
import com.biblior.biblior.repositories.PrintedRepository;
import com.biblior.biblior.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BibliorApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(BibliorApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PrintedRepository printedRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        printedRepository.deleteAll();
        Reader reader1 = new Reader("Drake", "Ramorey", "vasilisa94@gmail.com");
        Reader reader2 = new Reader("Quellor", "Disembarking", "sarah24@yahoo.com");
        Warehouser warehouser1 = new Warehouser("Jake", "Leibniz", "ilovehotmoms@mail.ru");
        Librarian librarian1 = new Librarian("Thor", "Odinson", "callmegus@gmail.com");
        userRepository.saveAll(new ArrayList<User>(Arrays.asList(reader1, reader2, warehouser1, librarian1)));
        Book b1 = new Book("1001 Nights", "Jack Sparrow", 1001, 199, 34.50, Genres.FAIRYTALE);
        Book b2 = new Book("1001", "Jack Nightingale", 1999, 200, 34.69, Genres.FAIRYTALE);
        Book b3 = new Book("1001 Days", "Jack Hawk", 2000, 189, 69.96, Genres.FAIRYTALE);
        Book b4 = new Book("1001 Evenings", "Jack Pigeon", 1888, 100, 100.50, Genres.FAIRYTALE);
        Newspaper n1 = new Newspaper("Man, cmmon", "Pravda", 1912, 2, 1.20, "Russia");
        Article a1 = new Article("McLovin as a cause of the 2008 economic crisis", "Mankew", 2007, 53, 20, "Economics");
//        printedRepository.saveAll(new ArrayList<Printed>(Arrays.asList(b1, b2, b3, b4, n1, a1)));
    }
}
