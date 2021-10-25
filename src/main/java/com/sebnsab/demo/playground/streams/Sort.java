package com.sebnsab.demo.playground.streams;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    public static void main(String[] args) {

        List<String> names = Arrays.asList( "Zebra","Lamp","Calendar","Glasses","Photos","Socks");

        List<String> sortedNames = names.stream()
                .sorted().collect(Collectors.toList());

        System.out.println(sortedNames);

        List<Person1> persons = Arrays.asList(
                new Person1("per1", 10),
                new Person1("per2", 55),
                new Person1("per3", 42),
                new Person1("per4", 56),
                new Person1("per5", 12)
        );

        Comparator<Person1> comparator = Comparator.comparing((t) -> t.getNumber());




    }
}

@Getter
@Setter
@ToString
class Person1 {
    private String name;
    private Integer number;

    Person1(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

}
