package com.biblior.biblior.entities;

import javax.persistence.Entity;

@Entity
public class Warehouser extends User{
    public Warehouser() {
    }

    public Warehouser(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
}
