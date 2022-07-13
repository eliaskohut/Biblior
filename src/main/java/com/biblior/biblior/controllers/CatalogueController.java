package com.biblior.biblior.controllers;

import com.biblior.biblior.services.PrintedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogueController {
    private PrintedService printedService;

    public CatalogueController(PrintedService printedService) {
        super();
        this.printedService = printedService;
    }
    @GetMapping("/catalogue")
    public String listPrinted(Model model){
        model.addAttribute("printed", printedService.getAllPrinted());
        return "catalogue";
    }
}
