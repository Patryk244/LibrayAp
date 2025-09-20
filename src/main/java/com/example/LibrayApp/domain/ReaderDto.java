package com.example.LibrayApp.domain;

import lombok.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReaderDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate createdAccount;
}