package com.example.jacksonannotations.jsonserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends JsonSerializer<Date> {
        private static SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

        @Override
        public void serialize(
                Date date,
                JsonGenerator jsonGenerator,
                SerializerProvider serializerProvider)
                throws IOException {

            jsonGenerator.writeString(formatter.format(date));
        }
}
