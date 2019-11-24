package com.sebnsab.demo.model.lombok;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequiredArgSample {

    private final String name; // having final will cause Lombok to create a constructor for this property
    private String secondName;

}
