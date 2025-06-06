package com.teste.wayonTiago.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorRecordResponse> handleNotFoundException(NotFoundException ex) {
        ErrorRecordResponse errorRecordResponse = new ErrorRecordResponse((HttpStatus.NOT_FOUND.value()), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorRecordResponse);
    }

    @ExceptionHandler(CharacterException.class)
    public ResponseEntity<ErrorRecordResponse> handleCharacterException(CharacterException ex) {
        ErrorRecordResponse errorRecordResponse = new ErrorRecordResponse((HttpStatus.BAD_REQUEST.value()), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRecordResponse);
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<ErrorRecordResponse> handleEmptyException(EmptyException ex) {
        ErrorRecordResponse errorRecordResponse = new ErrorRecordResponse((HttpStatus.BAD_REQUEST.value()), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRecordResponse);
    }

    @ExceptionHandler(NumericException.class)
    public ResponseEntity<ErrorRecordResponse> handlenumericException(NumericException ex) {
        ErrorRecordResponse errorRecordResponse = new ErrorRecordResponse((HttpStatus.BAD_REQUEST.value()), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRecordResponse);
    }
}
