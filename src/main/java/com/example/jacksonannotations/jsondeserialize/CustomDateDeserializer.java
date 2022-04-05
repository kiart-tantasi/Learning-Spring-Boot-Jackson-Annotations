package com.example.jacksonannotations.jsondeserialize;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public Date deserialize(JsonParser p, DeserializationContext context) throws IOException, JacksonException {
        String incomingDate = p.getText();

        try {
            Date result = formatter.parse(incomingDate);
            return result;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}