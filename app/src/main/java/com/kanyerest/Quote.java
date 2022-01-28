package com.kanyerest;

import com.google.firebase.database.PropertyName;

import lombok.Data;

@Data
public class Quote {

    @PropertyName("quote")
    private String quote;
}
