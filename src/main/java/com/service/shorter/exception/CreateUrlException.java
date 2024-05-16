package com.service.shorter.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUrlException extends RuntimeException  {
    private String message;
    private HttpStatus status;


}
