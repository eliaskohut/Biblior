package com.example.biblior.repositories;

import com.example.biblior.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<? extends User> findByRoleContaining(String admin);
}
