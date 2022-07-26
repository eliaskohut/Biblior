package com.example.biblior.repositories;

import com.example.biblior.entities.Printed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintedRepository extends JpaRepository<Printed, Long> {
    List<? extends Printed> findByPrintedTypeContaining(String book);
}
