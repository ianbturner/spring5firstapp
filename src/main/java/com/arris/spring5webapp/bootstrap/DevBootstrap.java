package com.arris.spring5webapp.bootstrap;

import com.arris.spring5webapp.model.Author;
import com.arris.spring5webapp.model.Book;
import com.arris.spring5webapp.model.Publisher;
import com.arris.spring5webapp.repositories.AuthorRepository;
import com.arris.spring5webapp.repositories.BookRepository;
import com.arris.spring5webapp.repositories.PublisherRepository;
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
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initData(){
        //Eric
        Author eric = new Author( "Eric", "Evans");
        Publisher harperCollins = new Publisher( "Harper Collins", "28 Kingsley Close", "Harrogate", "North Yorkshire", "England", "HG1 4RA");
        Book ddd = new Book( "Domain Driven Design", "123", harperCollins);
        eric.getBooks().add( ddd );
        ddd.getAuthors().add( eric );

        // Save the book and author to the database
        authorRepository.save( eric );
        publisherRepository.save(harperCollins);
        bookRepository.save( ddd );

        // Rod
        Author rod = new Author( "Rod", "Johnson" );
        Publisher worx = new Publisher( "Worx", "30 Kingsley Close", "Harrogate", "North Yorkshire", "England", "HG1 4RA");
        Book noEJB = new Book( "J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add( rod );

        // Save the book and author to the database
        authorRepository.save( rod );
        publisherRepository.save( worx );
        bookRepository.save( noEJB );
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
