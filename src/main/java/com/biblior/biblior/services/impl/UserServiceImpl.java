package com.biblior.biblior.services.impl;

import com.biblior.biblior.entities.User;
import com.biblior.biblior.repositories.UserRepository;
import com.biblior.biblior.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
