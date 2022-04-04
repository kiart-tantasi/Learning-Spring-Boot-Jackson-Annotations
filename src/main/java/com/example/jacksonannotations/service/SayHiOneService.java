package com.example.jacksonannotations.service;

import org.springframework.stereotype.Service;

@Service
public class SayHiOneService implements SayHiService {
    @Override
    public String sayHi() {
        return "Hello world !";
    }
}