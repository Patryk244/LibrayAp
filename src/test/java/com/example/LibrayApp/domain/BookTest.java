package com.example.LibrayApp.domain;

import com.example.LibrayApp.service.DbService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookTest {

    @Autowired
    private DbService dbService;

   // @AfterEach
    void init() {
        dbService.deleteAllInDatabaseForBookRepository();
    }

    @Test
    void saveBook() {
        Book book1 = new Book(null, "Intresting Book", "Andrzej Konopski", 2012);
        Book book2 = new Book(null, "Good Book", "John Smith", 1950);
        dbService.saveBook(book1);
        dbService.saveBook(book2);
        List<Book> found = dbService.findAllInDatabaseForBookRepository();
        assertEquals(2,  found.size());
    }
}