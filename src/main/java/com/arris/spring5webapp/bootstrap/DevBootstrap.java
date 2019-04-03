package com.arris.spring5webapp.bootstrap;

import com.arris.spring5webapp.model.Author;
import com.arris.spring5webapp.model.Book;
import com.arris.spring5webapp.repositories.AuthorRepository;
import com.arris.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/*
    Created by IBT 3/4/19
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void initData(){
        //Eric
        Author eric = new Author( "Eric", "Evans");
        Book ddd = new Book( "Domain Driven Design", "123", "Harper Collins");
        eric.getBooks().add( ddd );
        ddd.getAuthors().add( eric );

        // Save the book and author to the database
        authorRepository.save( eric );
        bookRepository.save( ddd );

        // Rod
        Author rod = new Author( "Rod", "Johnson" );
        Book noEJB = new Book( "J2EE Development without EJB", "2344", "Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add( rod );

        // Save the book and author to the database
        authorRepository.save( rod );
        bookRepository.save( noEJB );
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
