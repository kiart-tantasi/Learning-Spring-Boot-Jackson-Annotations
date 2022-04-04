package com.example.jacksonannotations.jsonserialize;

import com.fasterxml.jackson.annotation.JsonValue;

public class PersonJsonValue {
    private String firstName;
    private String lastName;

    public PersonJsonValue(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonValue
    public String getSerialized() {
        return "His full name is " + this.firstName + " " + this.lastName + ".";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
