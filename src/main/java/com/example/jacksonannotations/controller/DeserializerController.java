package com.example.jacksonannotations.controller;

import com.example.jacksonannotations.jsondeserialize.*;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;

@RestController
public class DeserializerController {

    @GetMapping("jsoncreator")
    public PersonJsonCreator personJsonCreator() throws IOException {
        String jsonData = "{\"jsonFirstName\":\"Maria\",\"jsonLastName\":\"Okawa\"}";

        PersonJsonCreator result = new ObjectMapper()
                .readerFor(PersonJsonCreator.class)
                .readValue(jsonData);

        return result;
    }

    @GetMapping("jacksoninject")
    public PersonJacksonInject personJacksonInject() throws IOException {
        String jsonData = "{\"name\":\"dummy name\"}";

        InjectableValues injectId = new InjectableValues.Std()
                .addValue(int.class, 1);

        PersonJacksonInject result = new ObjectMapper()
                .reader(injectId)
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
    // This works like @JsonCreator with @JsonProperty
    // The difference is that @JsonCreator is used in constructor and @JsonSetter is used in set method

    @GetMapping("jsondeserialize")
    public String personJsonDeserialize() throws IOException {
        String jsonDate = "{\"name\":\"Gamma\",\"date\":\"1-1-2001 01:00:00\"}";

        PersonJsonDeserialize preResult = new ObjectMapper()
                .readerFor(PersonJsonDeserialize.class)
                .readValue(jsonDate);

        String nameResult = preResult.name;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateResult = formatter.format(preResult.date);
        return "After @JsonDeserialize: " + nameResult + " " + dateResult;
    }

    @GetMapping("jsonalias")
    public PersonJsonAlias personJsonAlias() throws IOException {
        String jsonData = "{\"first_name\":\"Kiart\",\"lastName\":\"Tantasi\"}";

        PersonJsonAlias result = new ObjectMapper()
                .readerFor(PersonJsonAlias.class)
                .readValue(jsonData);

        return result;
    }
    // This also works like @JsonCreator and @JsonSetter but it can accept multiple values (in String[] form).

    @GetMapping("jsonignoreproperties")
    public PersonJsonIgnoreProperties personJsonIgnoreProperties() throws IOException {
        String jsonData ="{\"firstName\":\"Kiart\",\"lastName\":\"Tantasi\",\"age\":30}";
        PersonJsonIgnoreProperties result = new ObjectMapper()
                .readerFor(PersonJsonIgnoreProperties.class)
                .readValue(jsonData);
        return result;
    }

}
