package com.example.biblior.service.impl;


import com.example.biblior.entities.*;
import com.example.biblior.repositories.UserRepository;
import com.example.biblior.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(User element) {
        userRepository.delete(element);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return (List<Admin>) userRepository.findByRoleContaining("Admin");
    }

    @Override
    public List<Reader> getAllReaders() {
        return (List<Reader>) userRepository.findByRoleContaining("Reader");
    }

    @Override
    public List<Librarian> getAllLibrarians() {
        return (List<Librarian>) userRepository.findByRoleContaining("Librarian");
    }

    @Override
    public List<WarehouseWorker> getAllWarehouseWorkers() {
        return (List<WarehouseWorker>) userRepository.findByRoleContaining("WarehouseWorker");
    }
}
