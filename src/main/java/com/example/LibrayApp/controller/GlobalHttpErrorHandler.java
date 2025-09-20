package com.example.LibrayApp.controller;


import com.example.LibrayApp.domain.ReaderNotFound;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleReaderNotFound(ReaderNotFound ex){
        return new ResponseEntity<>("Reader not found", HttpStatus.NOT_FOUND);
    }
}