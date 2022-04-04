package com.example.jacksonannotations.jsonconfig;

import com.example.jacksonannotations.jsonserialize.CustomDateSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Date;

// source: https://www.bswen.com/2019/06/springboot-How-to-do-custom-JSON-serialization-in-SpringBoot-apps.html

//@Configuration
public class JacksonConfig {
    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(Date.class, new CustomDateSerializer()); //change all Date object's json serialization
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }
}
