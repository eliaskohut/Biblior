package com.example.biblior.entities;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Librarian extends User{
    public Librarian() {
    }
    @Builder
    public Librarian(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
