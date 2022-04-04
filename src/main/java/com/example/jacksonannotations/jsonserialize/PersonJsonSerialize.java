package com.example.jacksonannotations.jsonserialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class PersonJsonSerialize {

    @JsonSerialize(using = CustomFullNameSerializer.class)
    private String name;

    @JsonSerialize(using = CustomDateSerializerTwo.class)
    private Date date;

    private Date dateNoJsonSerialize;

    public PersonJsonSerialize(String name, Date date) {
        this.name = name;
        this.date = date;
        this.dateNoJsonSerialize = date;
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.date;
    }

    public Date getDateNoJsonSerialize() {
        return this.dateNoJsonSerialize;
    }
}
