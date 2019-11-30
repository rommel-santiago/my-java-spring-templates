package com.sebnsab.demo.model.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter //Generates Getters for all private fields
@Setter //Generates Setters for all private fields
@EqualsAndHashCode(of = {"name"})  //generates equals and hash code
public class LombokModel {

    private String name;
    private Integer number;

}

