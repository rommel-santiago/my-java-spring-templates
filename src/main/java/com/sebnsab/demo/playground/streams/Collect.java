package com.sebnsab.demo.playground.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect {

    public static void main(String[] args) {

        List<String> courses = Arrays.asList( "Java", "JavaScript", "Spring", "React");

        //Create another list for all java related courses
        List<String> javacourses =
                courses.stream()
                .filter(x -> x.startsWith("Java"))
                .collect(Collectors.toList());

        System.out.println(javacourses);
    }
}
