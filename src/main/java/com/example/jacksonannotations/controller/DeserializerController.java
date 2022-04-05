package com.example.jacksonannotations.controller;

import com.example.jacksonannotations.jsondeserialize.*;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DeserializerController {

    @GetMapping("jsoncreator")
    public PersonJsonCreator personJsonCreator() throws IOException {
        String jsonData = "{\"jsonFirstName\":\"Maria\",\"jsonLastName\":\"Okawa\"}";

        PersonJsonCreator result = new ObjectMapper().readerFor(PersonJsonCreator.class).readValue(jsonData);

        return result;
    }

    @GetMapping("jacksoninject")
    public PersonJacksonInject personJacksonInject() throws IOException {
        String jsonData = "{\"name\":\"dummy name\"}";

        InjectableValues inject = new InjectableValues.Std()
                .addValue(int.class, 1);

        PersonJacksonInject result = new ObjectMapper()
                .reader(inject)
                .forType(PersonJacksonInject.class)
                .readValue(jsonData);

        System.out.println("RESULT: " + result);

        return result;
    }

    @GetMapping("jsonanysetter")
    public PersonJsonAnySetter personJsonAnySetter() throws IOException {
        String jsonData = "{\"name\":\"Keith\",\"sex\":\"male\",\"age\":\"23\"}";

        PersonJsonAnySetter result = new ObjectMapper()
                .readerFor(PersonJsonAnySetter.class)
                .readValue(jsonData);
        
        return result;
    }

    @GetMapping("jsonsetter")
    public PersonJsonSetter personJsonSetter() throws IOException {
        String jsonData = "{\"incomingJsonName\":\"John Benedict\"}";

        PersonJsonSetter result = new ObjectMapper()
                .readerFor(PersonJsonSetter.class)
                .readValue(jsonData);

        return result;
    }

    @GetMapping("jsondeserialize")
    public String personJsonDeserialize() throws IOException {
        String jsonDate = "{\"date\":\"1-1-2001 01:00:00\"}";

        PersonJsonDeserialize preResult = new ObjectMapper()
                .readerFor(PersonJsonDeserialize.class)
                .readValue(jsonDate);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String result = formatter.format(preResult.date);
        return result;
    }

    @GetMapping("jsondeserializefullname")
    public PersonJsonDeserializeFullName getFullName() throws IOException {
        String jsonData = "{\"name\":\"Gamma\"}";

        PersonJsonDeserializeFullName result = new ObjectMapper()
                .readerFor(PersonJsonDeserializeFullName.class)
                .readValue(jsonData);

        return result;
    }

    @GetMapping("jsonalias")
    public PersonJsonAlias personJsonAlias() throws IOException {
        String jsonData = "{\"first_name\":\"Kiart\",\"lastName\":\"Tantasi\"}";

        PersonJsonAlias result = new ObjectMapper()
                .readerFor(PersonJsonAlias.class)
                .readValue(jsonData);

        return result;
    }

}
