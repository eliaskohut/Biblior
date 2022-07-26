package com.example.biblior.entities;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "USERS")
public class Admin extends User{
    public Admin() {
    }
    @Builder
    public Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
