package com.example.LibrayApp.repository;

import com.example.LibrayApp.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book save(Book book);
    List<Book> findAll();
}