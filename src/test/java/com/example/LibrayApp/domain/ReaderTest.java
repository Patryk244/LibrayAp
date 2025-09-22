package com.example.LibrayApp.domain;

import com.example.LibrayApp.service.DbService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
class ReaderTest {

    @Autowired
    private DbService dbService;

  //  @AfterEach
    void init() {
        dbService.deleteAllInDatabaseForReaderRepository();
    }

    @Test
    void savingUserToDatabase() {
        Reader reader1 = new Reader(null,"Jan", "Kowalski", LocalDate.now());
        Reader reader2 = new Reader(null,"Michal", "Nowak", LocalDate.now());
        dbService.saveReader(reader1);
        dbService.saveReader(reader2);
        List<Reader> allReaders = dbService.findAllInDatabaseReaderRepository();
        System.out.println("Size for allReaders: " + allReaders.size());
        assertEquals(2, allReaders.size());
    }
}