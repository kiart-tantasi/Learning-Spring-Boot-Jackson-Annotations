package com.example.jsoncustom.jsonserialize;

import com.fasterxml.jackson.annotation.JsonGetter;

public class PersonJsonGetter {
    private double id;
    private String name;
    private String somethingElse;

    public PersonJsonGetter(String name) {
        this.id = Math.random();
        this.name = name;
        somethingElse = "something else";
    }

    public double getId() {
        return this.id;
    }

    @JsonGetter
    public String getName() {
        return this.name;
    }

    public String getSomethingElse() {
        return this.somethingElse;
    }
}
