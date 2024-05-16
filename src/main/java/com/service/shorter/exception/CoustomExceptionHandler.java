package com.service.shorter.exception;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class CoustomExceptionHandler {

    @ExceptionHandler(UrlExistException.class)
    public ResponseEntity<Object> handleUrlExistException(UrlExistException ex, UrlExistException request) {
        return new ResponseEntity <>(request.getMessage(), ex.getStatus());
    }
}
