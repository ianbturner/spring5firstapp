package com.arris.spring5webapp.controllers;

/*
 * Created by IBT on 3/4/19
 */

import com.arris.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors( Model model ){
        model.addAttribute( "authors", authorRepository.findAll());

        return "authors";
    }
}
