package com.example.biblior.entities;

import javax.persistence.Entity;

@Entity
public class Librarian extends User{
    public Librarian() {
    }

    public Librarian(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
