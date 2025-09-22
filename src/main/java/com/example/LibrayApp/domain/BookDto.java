package com.example.LibrayApp.domain;

import lombok.*;

@Getter
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private int yearOfPublication;
}