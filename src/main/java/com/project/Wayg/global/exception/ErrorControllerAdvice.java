package com.project.Wayg.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorControllerAdvice {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected ResponseEntity<ErrorResponse> pageHandlerException(Exception e) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.PAGE_NOT_FOUND);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> categoryHandlerException(Exception e) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.CATEGORY_NOT_SEARCH);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> keywordHandlerException(Exception e) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.KEYWORD_NOT_SEARCH);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
