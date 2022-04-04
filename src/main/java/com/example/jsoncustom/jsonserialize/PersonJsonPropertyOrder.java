package com.example.jsoncustom.jsonserialize;

// to get this (id / name / somethingElse)
// {"id":0.43746573775387776,"name":"json property order name test","somethingElse":"something else"}

// instead of (somethingElse / name / id)
// {"somethingElse":"something else","name":"json property order name test","id":0.4908941873614847}

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name", "somethingElse" })
public class PersonJsonPropertyOrder {
    private String somethingElse;
    private String name;
    private double id;

    public PersonJsonPropertyOrder(String name) {
        this.id = Math.random();
        this.name = name;
        this.somethingElse = "something else";
    }

    public double getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSomethingElse() {
        return this.somethingElse;
    }
}
