package com.biblior.biblior.entities;

import javax.persistence.Entity;

@Entity
public class Reader extends User{

    public Reader(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Reader() {

    }
}
