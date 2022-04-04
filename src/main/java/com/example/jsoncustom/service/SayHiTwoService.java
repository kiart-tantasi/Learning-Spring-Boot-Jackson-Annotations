package com.example.jsoncustom.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SayHiTwoService implements SayHiService {
    @Override
    public String sayHi() {
        return "How Are You ?";
    }
}