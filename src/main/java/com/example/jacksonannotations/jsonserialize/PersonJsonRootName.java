package com.example.jacksonannotations.jsonserialize;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "account", namespace="accounts") // (value = "account", namespace="accounts") for Xml Mapper
public class PersonJsonRootName {
    private String accountNumber;
    private Long balance;

    public PersonJsonRootName(String accountNumber, Long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }
}
