package com.arris.spring5webapp.controllers;

import com.arris.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Created by IBT on 3/4/19
 */


@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public  String getBooks( Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
