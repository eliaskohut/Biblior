package com.biblior.biblior.entities;

import javax.persistence.Entity;

@Entity
public class Librarian extends User{
    public Librarian() {
    }

    public Librarian(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
}
