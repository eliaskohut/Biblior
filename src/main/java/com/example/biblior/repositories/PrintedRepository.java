package com.example.biblior.repositories;

import com.example.biblior.entities.Printed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintedRepository extends JpaRepository<Printed, Long> {
}
