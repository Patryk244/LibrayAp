package com.example.LibrayApp.domain;


import com.example.LibrayApp.service.DbService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CopyBookTest {

    @Autowired
    private DbService dbService;

    @BeforeEach
    void addAllBook() {
        dbService.deleteAllFormCopyBookRepository();
        dbService.createBookCopy();
    }

    @Test
    void findAllCopyBook() {
        List<CopyBook> foundCopyBook = dbService.findAllInDatabaseForCopyBookRepository();
        assertEquals(4, foundCopyBook.size());
    }
}