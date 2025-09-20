package com.example.LibrayApp.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "READERS")
public class Reader {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "CREATED_ACCOUNT")
    private LocalDate createdAccount;
}