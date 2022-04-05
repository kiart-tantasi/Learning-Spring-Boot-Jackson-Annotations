package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.HashMap;
import java.util.Map;

public class PersonJsonAnySetter {
    public String name;
    public Map<String, String> properties = new HashMap<>();

    @JsonAnySetter
    public void addToMap(String key, String value) {
        properties.put(key, value);
    }

//    @JsonAnyGetter
//    public Map<String, String> getProperties() {
//        return this.properties;
//    }
}