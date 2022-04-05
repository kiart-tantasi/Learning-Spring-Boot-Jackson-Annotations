package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PersonJsonDeserializeFullName {
    @JsonDeserialize(using = CustomFullNameDeserialize.class)
    public String name;
}
