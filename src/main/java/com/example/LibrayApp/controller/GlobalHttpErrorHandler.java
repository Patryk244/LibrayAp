package com.example.LibrayApp.controller;

import com.example.LibrayApp.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleReaderNotFound(ReaderNotFound ex){
        return new ResponseEntity<>("Reader not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleBookNotFound(BookNotFound ex){
        return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
    }
}