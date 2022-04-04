package com.example.jsoncustom.entity;

import java.util.Date;

/*
@JsonSerialize(using = CustomDateSerializer.class)
"{
        "timestamp": "2022-04-04T15:59:18.646+00:00",
        "status": 500,
        "error": "Internal Server Error",
        "path": "/json"
}"
 */
public class Person {
    private String firstName;
    private String lastName;
//    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date recordDate; // "2022-04-04T15:49:49.536+00:00"

    public Person(String firstName, String lastName, Date recordDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.recordDate = recordDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getRecordDate() {
        return recordDate;
    }

}
