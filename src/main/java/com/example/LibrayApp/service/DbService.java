package com.example.LibrayApp.service;

import com.example.LibrayApp.domain.Book;
import com.example.LibrayApp.domain.Reader;
import com.example.LibrayApp.domain.ReaderNotFound;
import com.example.LibrayApp.repository.BookRepository;
import com.example.LibrayApp.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

   // @Autowired
    private final ReaderRepository readerRepository;

  //  @Autowired
    private final BookRepository bookRepository;

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteAllInDatabaseForReaderRepository() {
        readerRepository.deleteAll();
    }
    public List<Reader> findAllInDatabaseReaderRepository() {
        return readerRepository.findAll();
    }

    public void removeByIdInDatabaseReaderRepository(final Long id) {
        readerRepository.deleteById(id);
    }

    public List<Reader> findAllInDatabaseReaderRepositoryByReaderName(final String ReaderName) {
        return readerRepository.findByFirstName(ReaderName);
    }

    public Reader findReaderByUsingId(final Long Reader_Id) throws ReaderNotFound {
        return readerRepository.findById(Reader_Id).orElseThrow(ReaderNotFound::new);
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