package com.example.jsoncustom.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHandler {
    public static ResponseEntity<HashMap> createResponse(
            String message,
            HttpStatus httpStatus,
            Object object
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("message", message);
        hashMap.put("status", httpStatus.value());
        hashMap.put("data", object);

        return new ResponseEntity<>(hashMap, httpStatus);
    }
}
