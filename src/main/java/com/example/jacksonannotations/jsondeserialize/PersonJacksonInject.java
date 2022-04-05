package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.annotation.JacksonInject;

public class PersonJacksonInject {
    @JacksonInject
    public int id;
    public String name;
}
