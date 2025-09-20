package com.example.LibrayApp.service;

import com.example.LibrayApp.domain.Book;
import com.example.LibrayApp.domain.Reader;
import com.example.LibrayApp.repository.BookRepository;
import com.example.LibrayApp.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private final ReaderRepository readerRepository;

    @Autowired
    private final BookRepository bookRepository;

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteAllInDatabaseForReaderRepository() {
        readerRepository.deleteAll();
    }
    public List<Reader> findAllInDatabase() {
        return readerRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteAllInDatabaseForBookRepository() {
        bookRepository.deleteAll();
    }
    public List<Book> findAllInDatabaseForBookRepository() {
        return bookRepository.findAll();
    }
}