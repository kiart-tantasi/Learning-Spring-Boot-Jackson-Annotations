package com.example.jsoncustom.jsonserialize;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.HashMap;
import java.util.Map;

// to get this format
//{
//    "name":"object name",
//    "key 1":"value 1",
//    "key 2":"value 2"
//}

// instead of this format
//{
//    "name":"JSON ANY GETTER",
//        "properties":
//        {
//            "this is second key":"this is second value",
//            "this is first key":"this is first value"
//        }
//}

public class PersonJsonAnyGetter {
    private String name;
    private Map<String, String> properties;

    public PersonJsonAnyGetter(String name) {
        this.name = name;
        this.properties = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void add(String key, String value) {
        properties.put(key, value);
    }
}
