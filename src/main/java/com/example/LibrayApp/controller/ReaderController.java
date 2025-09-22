package com.example.LibrayApp.controller;

import com.example.LibrayApp.domain.*;
import com.example.LibrayApp.mapper.ReaderMapper;
import com.example.LibrayApp.service.DbService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/v1/reader")
public class ReaderController {

    @Autowired
    private DbService dbService;
    @Autowired
    private ReaderMapper readerMapper;

    @GetMapping
    public List<ReaderDto> getAllReader() {
        List<Reader> allReader = dbService.findAllInDatabaseReaderRepository();
        return readerMapper.mapToReaderDtoList(allReader);
    }

    @GetMapping(value = "/name/{ReaderName}")
    public List<ReaderDto> getReaderByName(@PathVariable String ReaderName) {
        List<Reader> findByName = dbService.findAllInDatabaseReaderRepositoryByReaderName(ReaderName);
        return readerMapper.mapToReaderDtoList(findByName);
    }

    @GetMapping(value = "/{Reader_Id}")
    public ResponseEntity<ReaderDto> getReaderById(@PathVariable Long Reader_Id) throws ReaderNotFound {
        return ResponseEntity.ok(readerMapper.mapToReaderDto(dbService.findReaderByUsingId(Reader_Id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(new ReaderDto(
                null,
                readerDto.getFirstName(),
                readerDto.getLastName(),
                LocalDate.now()
        ));
        dbService.saveReader(reader);
    }

    @Transactional
    @DeleteMapping("/{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long readerId) throws ReaderNotFound {
        try {
            dbService.removeByIdInDatabaseReaderRepository(readerId);
        } catch (Exception e) {
            throw new ReaderNotFound();
        }
        return ResponseEntity.ok().build();
    }
}