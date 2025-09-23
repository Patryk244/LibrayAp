package com.example.LibrayApp.controller;


import com.example.LibrayApp.domain.*;
import com.example.LibrayApp.mapper.CopyBookMapper;
import com.example.LibrayApp.repository.*;
import com.example.LibrayApp.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/copy")
public class CopyBookController {
    @Autowired
    private CopyBookMapper copyBookMapper;
    @Autowired
    private DbService dbService;

    @GetMapping
    public List<CopyBookDto> findAllInDatabaseForBookRepository()  {
        return copyBookMapper.mapToCopyBookDtoList(dbService.findAllInDatabaseForCopyBookRepository());
    }

    @PutMapping
    public ResponseEntity<CopyBookDto> updateCopyBook(@RequestBody CopyBookDto copyBookDto) {
        CopyBook copyBook = copyBookMapper.mapToCopyBook(copyBookDto);
        CopyBook savedCopyBook = dbService.saveCopyBook(copyBook);
        return ResponseEntity.ok(copyBookMapper.mapToCopyBookDto(savedCopyBook));
    }

    @GetMapping("/{to_count}")
    public String numberForCopy(@PathVariable String to_count) {
        long titleFindByTitle = dbService.counterNumberTitle(to_count);
        System.out.println(titleFindByTitle);
        return "Title: " + to_count + "found in quantity: " + titleFindByTitle;
    }
}
