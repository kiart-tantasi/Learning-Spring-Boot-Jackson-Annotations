package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonJsonCreator {
    public String firstName;
    public String lastName;

    @JsonCreator
    public PersonJsonCreator(
            @JsonProperty("jsonFirstName") String jsonFirstName,
            @JsonProperty("jsonLastName") String jsonLastName
    ) {
        this.firstName = jsonFirstName;
        this.lastName = jsonLastName;
    }
}
