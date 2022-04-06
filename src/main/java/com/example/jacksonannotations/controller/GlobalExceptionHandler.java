package com.example.jacksonannotations.controller;

import com.example.jacksonannotations.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<HashMap> misMatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        return ResponseHandler.createResponse(
                "Type Mismatched",
                HttpStatus.BAD_REQUEST,
                null
        );
    }

    @ExceptionHandler
    public ResponseEntity<HashMap> allExceptionsHandler(Exception ex) {
        return ResponseHandler.createResponse(
                "Bad Request",
                HttpStatus.BAD_REQUEST,
                null
        );
    }

}
