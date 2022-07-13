package com.biblior.biblior;

import com.biblior.biblior.entities.*;
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
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        Reader reader1 = new Reader("Drake", "Ramorey", "vasilisa94@gmail.com");
        Reader reader2 = new Reader("Quellor", "Disembarking", "sarah24@yahoo.com");
        Warehouser warehouser1 = new Warehouser("Jake", "Leibniz", "ilovehotmoms@mail.ru");
        Librarian librarian1 = new Librarian("Thor", "Odinson", "callmegus@gmail.com");
        userRepository.saveAll(new ArrayList<User>(Arrays.asList(reader1, reader2, warehouser1, librarian1)));
    }
}
