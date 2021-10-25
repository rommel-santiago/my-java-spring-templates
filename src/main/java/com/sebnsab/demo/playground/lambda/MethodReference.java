package com.sebnsab.demo.playground.lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MethodReference {

    public static void main(String[] args) {


        try {

            throw new RuntimeException("blah");
        } finally {
            System.out.println("finally");
        }
/*
        List<Person2> persons = Arrays.asList(
                new Person2("jeeps"),
                new Person2("rache"),
                new Person2("sebi"),
                new Person2("sab"));

        persons.stream()
                .map(Person2::getName) // by public method of class
                .map(String::toUpperCase) // also by public method of class
                .map(MethodReference::addSuffix)  // by static method
                .forEach(System.out::println);
*/

    }
    private static String addSuffix(String name) {
        return name.concat("_suffix");
    }

    private interface Lambda1 {
        public void assignNumber(Integer randomNumber);
    }
}

@Getter
@Setter
@ToString
class Person2 {
    private String name;
    private Integer randomNumber;

    Person2(String name) {
        this.name = name;
    }


}