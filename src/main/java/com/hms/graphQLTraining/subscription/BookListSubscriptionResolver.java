package com.hms.graphQLTraining.subscription;

import com.hms.graphQLTraining.domain.Book;
import com.hms.graphQLTraining.repository.BookRepository;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class BookListSubscriptionResolver implements GraphQLSubscriptionResolver {

    private final BookRepository bookRepository;

    @Autowired
    public BookListSubscriptionResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Publisher<List<Book>> books(){
       return subscriber ->  Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()->{
                   List<Book> books = bookRepository.findBookList();
                   subscriber.onNext(books);
                   subscriber.onComplete();
               },0,2, TimeUnit.SECONDS);
           }



}
