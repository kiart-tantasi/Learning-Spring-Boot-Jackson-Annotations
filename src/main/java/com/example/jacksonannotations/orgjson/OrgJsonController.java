package com.example.jacksonannotations.orgjson;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgJsonController {

    @GetMapping("orgjson")
    public String orgJson() {

        String jsonString = new JSONObject()
                .put("name", "Keith Tantasi")
                .put("age", 23)
                .put(
                        "properties",
                        new JSONObject()
                                .put("propertyOne", "valueOne")
                                .put("propertyTwo", "valueTwo")
                )
                .toString();

        return jsonString;
    }
}
