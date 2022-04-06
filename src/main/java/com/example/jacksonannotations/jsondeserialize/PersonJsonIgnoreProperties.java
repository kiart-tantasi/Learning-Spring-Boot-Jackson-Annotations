package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonJsonIgnoreProperties {
    public String firstName;
    public String lastName;
}

// --- @JsonIgnoreProperties(ignoreUnknown = true) --- //
//        "Unrecognized field "age" (class com.example.jacksonannotations.jsondeserialize.PersonJsonIgnoreProperties), " +
//        "not marked as ignorable (2 known properties: "lastName", "firstName"]) at [Source: (String)"{"firstName"
//        :"Kiart","lastName":"Tantasi","age":30}"; line: 1, column: 51] (through reference chain: com.example.jacksonannotations." +
//        "jsonserialize.PersonJsonIgnoreProperties["age"])"
