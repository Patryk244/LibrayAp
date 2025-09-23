package com.example.LibrayApp.service;

import com.example.LibrayApp.domain.*;
import com.example.LibrayApp.repository.BookRepository;
import com.example.LibrayApp.repository.CopyBookRepository;
import com.example.LibrayApp.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DbService {

    private final ReaderRepository readerRepository;

    private final BookRepository bookRepository;

    private final CopyBookRepository copyBookRepository;

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

    public List<Reader> findAllInDatabaseReaderRepositoryByReaderName(final String ReaderName) throws ReaderNotFound {
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

    public void removeByIdInDatabaseForBookRepository(final Long id) throws BookNotFound {
        bookRepository.deleteById(id);
    }

    public Book findBookByUsingId(final Long Book_Id) throws BookNotFound {
        return bookRepository.findById(Book_Id).orElseThrow(BookNotFound::new);
    }

    public CopyBook saveCopyBook(CopyBook copyBook) {
        return copyBookRepository.save(copyBook);
    }

    public Iterable<CopyBook> createBookCopy() {
        List<Book> books = findAllInDatabaseForBookRepository();
        List<CopyBook> preparedCopyBookToSave = new ArrayList<>();
        for (Book book : books) {
            preparedCopyBookToSave.add(new CopyBook(null, book, StatusCopyOfBook.AVAILABLE));
        }
        return copyBookRepository.saveAll(preparedCopyBookToSave);
    }

    public List<CopyBook> findAllInDatabaseForCopyBookRepository() {
        return copyBookRepository.findAll();
    }

    public void deleteAllFormCopyBookRepository() {
        copyBookRepository.deleteAll();
    }

    public long counterNumberTitle(String title) throws CopyBookNotFound {
        return copyBookRepository.countCopyBookByBook_Title(title);
    }
}