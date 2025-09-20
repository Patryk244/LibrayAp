package com.example.LibrayApp.service;

import com.example.LibrayApp.domain.Reader;
import com.example.LibrayApp.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private final ReaderRepository readerRepository;

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteAllInDatabase() {
        readerRepository.deleteAll();
    }
    public List<Reader> findAllInDatabase() {
        return readerRepository.findAll();
    }
}