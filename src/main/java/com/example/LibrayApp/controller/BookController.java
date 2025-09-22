package com.example.LibrayApp.controller;

import com.example.LibrayApp.domain.*;
import com.example.LibrayApp.mapper.*;
import com.example.LibrayApp.service.DbService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private DbService dbService;

    @GetMapping
    public List<BookDto> findAllBooks() {
        return bookMapper.mapToBookDtoList(dbService.findAllInDatabaseForBookRepository());
    }

    @GetMapping(value = "/{book_id}")
    public ResponseEntity<BookDto> findBookById(@PathVariable Long book_id) throws BookNotFound {
        return ResponseEntity.ok(bookMapper.mapToBookDto(dbService.findBookByUsingId(book_id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(new BookDto(
                null,
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYearOfPublication()
        ));
        dbService.saveBook(book);
    }

    @Transactional
    @DeleteMapping("/{book_id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long book_id) throws BookNotFound {
        try {
            dbService.removeByIdInDatabaseForBookRepository(book_id);
        } catch (Exception e) {
            throw new BookNotFound();
        }
        return ResponseEntity.ok().build();
    }
}