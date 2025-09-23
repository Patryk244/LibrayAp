package com.example.LibrayApp.domain;

import lombok.*;

@Getter
@AllArgsConstructor
public class CopyBookDto {
    private Long copyBook_id;
    private Book book;
    private StatusCopyOfBook statusCopyOfBook;
}
