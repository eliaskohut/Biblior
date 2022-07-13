package com.biblior.biblior.services.impl;

import com.biblior.biblior.entities.Printed;
import com.biblior.biblior.repositories.PrintedRepository;
import com.biblior.biblior.services.PrintedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintedServiceImpl implements PrintedService {
    private PrintedRepository printedRepository;

    public PrintedServiceImpl(PrintedRepository printedRepository) {
        super();
        this.printedRepository = printedRepository;
    }

    @Override
    public List<Printed> getAllPrinted() {
        return printedRepository.findAll();
    }
}
