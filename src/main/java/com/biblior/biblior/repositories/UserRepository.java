package com.biblior.biblior.repositories;

import com.biblior.biblior.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
