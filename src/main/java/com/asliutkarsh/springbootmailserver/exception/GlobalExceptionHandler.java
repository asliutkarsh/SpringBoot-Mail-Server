package com.asliutkarsh.springbootmailserver.exception;

import com.asliutkarsh.springbootmailserver.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleExtraException(Exception ex) {
        log.error("Exception occurred: ", ex);
        return new ResponseEntity<>(new ApiResponse("There is some error with server right now",false), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
