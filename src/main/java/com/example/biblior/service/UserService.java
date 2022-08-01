package com.example.biblior.service;

import com.example.biblior.entities.*;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void deleteUser(User element);
    List<Admin> getAllAdmins();
    List<Reader> getAllReaders();
    List<Librarian> getAllLibrarians();
    List<WarehouseWorker> getAllWarehouseWorkers();
}
