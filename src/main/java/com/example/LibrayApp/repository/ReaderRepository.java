package com.example.LibrayApp.repository;

import com.example.LibrayApp.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends CrudRepository<Reader,Long> {
    Reader save(Reader reader);
    List<Reader> findAll();
    List<Reader> findByFirstName(@Param("ReaderName") String ReaderName);
    Optional<Reader> findById(@Param("Reader_Id") Long Reader_Id);
}