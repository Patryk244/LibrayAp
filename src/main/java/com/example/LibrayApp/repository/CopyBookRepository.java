package com.example.LibrayApp.repository;

import com.example.LibrayApp.domain.CopyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Repository
public interface CopyBookRepository extends CrudRepository<CopyBook, Long> {
    List<CopyBook> findAll();
    long countCopyBookByBook_Title(@PathVariable String bookTitle);
}