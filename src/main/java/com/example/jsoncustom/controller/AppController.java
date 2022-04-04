package com.example.jsoncustom.controller;

import com.example.jsoncustom.entity.*;
import com.example.jsoncustom.jsonserialize.*;
import com.example.jsoncustom.response.ResponseHandler;
import com.example.jsoncustom.service.SayHiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

// SOURCE: https://www.baeldung.com/jackson-annotations

@RestController
public class AppController {

    @GetMapping("/test")
    public ResponseEntity<Person> getDummyJson() {

        Person firstPerson = new Person("Kiart", "Tantasi", new Date());
        return new ResponseEntity<>(firstPerson, HttpStatus.OK);
    }

    @GetMapping("/json/{id}")
    public ResponseEntity<HashMap> withResponseHandler(@PathVariable int id) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("A");
        stringArrayList.add("B");

        if (id >= stringArrayList.size() || id < 0) {
            return ResponseHandler.createResponse(
                    "no user found with id " + id,
                    HttpStatus.NOT_FOUND,
                    null
            );
        }

        return ResponseHandler.createResponse(
                "success request",
                HttpStatus.OK,
                new String[] { stringArrayList.get(id) }
        );
    }

    @GetMapping("jsonanygetter")
    public PersonJsonAnyGetter jsonAnyGetter() throws JsonProcessingException {
        PersonJsonAnyGetter personJsonAnyGetter = new PersonJsonAnyGetter("JSON ANY GETTER");
        personJsonAnyGetter.add("this is first key", "this is first value");
        personJsonAnyGetter.add("this is second key", "this is second value");
        return personJsonAnyGetter;
    }

    @GetMapping("jsongetter")
    public PersonJsonGetter jsonGetter() throws JsonProcessingException {
        PersonJsonGetter personJsonGetter = new PersonJsonGetter("json getter test");
        return personJsonGetter;
    }

    @GetMapping("jsonpropertyorder")
    public PersonJsonPropertyOrder jsonPropertyOrder() throws JsonProcessingException {
        PersonJsonPropertyOrder personJsonPropertyOrder = new PersonJsonPropertyOrder("json property order name test");
        return personJsonPropertyOrder;
    }

    @GetMapping("jsonrawvalue")
    public PersonJsonRawValue personJsonRawValue() throws JsonProcessingException {
        PersonJsonRawValue personJsonRawValue = new PersonJsonRawValue("{\"id\":123}");
        return personJsonRawValue;
    }

    @GetMapping("jsonvalue")
    public PersonJsonValue personJsonValue() throws JsonProcessingException {
        PersonJsonValue personJsonValue = new PersonJsonValue("John", "Benedict");
        return personJsonValue;
    }

    @GetMapping("jsonrootname")
    public String personJsonRootName() throws JsonProcessingException {
        PersonJsonRootName personJsonRootName = new PersonJsonRootName("564236",5000L);
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(personJsonRootName);
        return result;
    }

    @GetMapping("jsonserialize")
    public PersonJsonSerialize personJsonSerialize() throws JsonProcessingException {
        PersonJsonSerialize personJsonSerialize = new PersonJsonSerialize("John", new Date());
        return personJsonSerialize;
    }




    // -------- test two instances -------- // (not related to Jackson Annotations)
    private final SayHiService sayHiService;
    @Autowired
    public AppController(SayHiService sayHiService) { // @Qualifier("sayHiOneService")
        this.sayHiService = sayHiService;
    }
    @GetMapping("/service")
    public String sayHi() {
        return this.sayHiService.sayHi();
    }
    // -------- test two instances -------- //
}
