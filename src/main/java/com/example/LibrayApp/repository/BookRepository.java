package com.example.LibrayApp.repository;

import com.example.LibrayApp.domain.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book save(Book book);
    List<Book> findAll();
}