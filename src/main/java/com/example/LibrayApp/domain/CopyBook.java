package com.example.LibrayApp.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COPY_BOOKS")
public class CopyBook {
    @Id
    @GeneratedValue
    private Long copyBook_id;

    @JoinColumn(name = "book_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusCopyOfBook statusCopyOfBook;
}