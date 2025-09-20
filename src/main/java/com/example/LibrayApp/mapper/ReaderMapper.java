package com.example.LibrayApp.mapper;

import com.example.LibrayApp.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReaderMapper {

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getCreatedAccount()
        );
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getCreatedAccount()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(List<Reader> readersList) {
        return readersList.stream()
                .map(this::mapToReaderDto)
                .toList();
    }
}