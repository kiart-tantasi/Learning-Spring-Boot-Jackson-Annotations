package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class PersonJsonSetter {
    private String name;

    @JsonSetter("incomingJsonName")
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("JsonGetter Name") // if not, it is going to be {"incomingJsonName": "John Benedict"}
    public String getName() {
        return this.name;
    }
}