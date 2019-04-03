package com.arris.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.arris.spring5webapp.model.Book;

/*
    Created by IBT 3/4/19
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
