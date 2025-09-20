package com.example.LibrayApp.repository;

import com.example.LibrayApp.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReaderRepository extends CrudRepository<Reader,Long> {
    Reader save(Reader reader);
    List<Reader> findAll();
}