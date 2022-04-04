package com.example.jsoncustom.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class SayHiOneService implements SayHiService {
    @Override
    public String sayHi() {
        return "Hello world !";
    }
}