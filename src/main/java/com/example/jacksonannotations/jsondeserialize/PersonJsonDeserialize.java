package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class PersonJsonDeserialize {
    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date date;
}
