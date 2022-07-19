package com.example.biblior.entities;

import javax.persistence.Entity;

@Entity
public class Reader extends User{
    public Reader() {
    }

    public Reader(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
