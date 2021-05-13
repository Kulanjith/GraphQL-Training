package com.hms.graphQLTraining.resolver;

import com.hms.graphQLTraining.domain.Book;
import com.hms.graphQLTraining.exceptions.ResourceNotFoundException;
import com.hms.graphQLTraining.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookResolver implements GraphQLQueryResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentQueryResolver.class);

    private final BookRepository bookRepository;

    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Connection<Book> books(int first, String after, DataFetchingEnvironment env){
        List<Book> books = bookRepository.findBookList();
        return new SimpleListConnection<>(books).get(env);
    }
    public List<Book> findBookList() {
        LOGGER.info("Request all the books");
        final List<Book> bookList = bookRepository.findBookList();
        if(!bookList.isEmpty()) {
            LOGGER.info("Requested all the books [{}]", bookList.size());
            return bookList;
        }
        throw new ResourceNotFoundException("No Books to Preview");
    }
}
