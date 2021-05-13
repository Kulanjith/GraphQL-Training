package com.hms.graphQLTraining.repository;

import com.hms.graphQLTraining.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> bookList;

    public BookRepository() {
        this.bookList = new ArrayList<>();
        bookList.add(new Book(1245,"Jane Eyre", "Charlot Bronte"));
        bookList.add(new Book(1285,"Village By the Sea", "Anita Desai"));
        bookList.add(new Book(1259,"Mother", "Maximum Ghorky"));
        bookList.add(new Book(1273,"Anne Frank huis", "Anne Frank"));
//        bookList.add(new Book(12123,"Famous Five", " Eileen Soper"));
//        bookList.add(new Book(1258,"Harry Potter ", "J.K. Rowlling"));
//        bookList.add(new Book(13245,"Pinocchio", "Carlo Collodi"));
//        bookList.add(new Book(14586,"Alice's Adventures in Wonderland", "Lewis Carroll"));
    }

    public  List<Book> findBookList() {
        return Collections.unmodifiableList(bookList);
    }
}
