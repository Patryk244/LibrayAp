package com.example.LibrayApp.mapper;

import com.example.LibrayApp.domain.CopyBook;
import com.example.LibrayApp.domain.CopyBookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyBookMapper {

    public CopyBook mapToCopyBook(CopyBookDto copyBookDto) {
        return new CopyBook(
                copyBookDto.getCopyBook_id(),
                copyBookDto.getBook(),
                copyBookDto.getStatusCopyOfBook()
        );
    }

    public CopyBookDto mapToCopyBookDto(CopyBook copyBook) {
        return new CopyBookDto(
                copyBook.getCopyBook_id(),
                copyBook.getBook(),
                copyBook.getStatusCopyOfBook()
        );
    }

    public List<CopyBookDto> mapToCopyBookDtoList(List<CopyBook> copyBooksList) {
        return copyBooksList.stream()
                .map(this::mapToCopyBookDto)
                .toList();
    }

    public List<CopyBook> mapToCopyBookList(List<CopyBookDto> copyBookDtoList) {
        return copyBookDtoList.stream()
                .map(this::mapToCopyBook)
                .toList();
    }
}
