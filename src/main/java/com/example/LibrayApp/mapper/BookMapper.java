package com.example.LibrayApp.mapper;

import com.example.LibrayApp.domain.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYearOfPublication()
        );
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId_book(),
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublication()
        );
    }

    public List<BookDto> mapToBookDtoList(List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .toList();
    }
}