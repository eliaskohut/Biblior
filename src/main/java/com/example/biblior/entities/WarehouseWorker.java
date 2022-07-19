package com.example.biblior.entities;

import javax.persistence.Entity;

@Entity
public class WarehouseWorker extends User{
    public WarehouseWorker() {
    }

    public WarehouseWorker(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
