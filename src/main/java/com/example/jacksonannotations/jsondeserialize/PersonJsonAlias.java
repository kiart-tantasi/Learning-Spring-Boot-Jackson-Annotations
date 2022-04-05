package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PersonJsonAlias {
    @JsonAlias({"nameFirst", "first_name"})
    public String firstName;
    public String lastName;
}
