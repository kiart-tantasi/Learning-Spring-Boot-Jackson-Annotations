package com.example.jacksonannotations.jsonserialize;

import com.fasterxml.jackson.annotation.JsonGetter;

public class PersonJsonGetter {
    private String name;

    public PersonJsonGetter(String name) {
        this.name = name;
    }

    @JsonGetter("name")
    public String getNameWithJsonGetter() {
        return this.name;
    }

    public String getNameWithoutJsonGetter() {
        return this.name;
    }
}
