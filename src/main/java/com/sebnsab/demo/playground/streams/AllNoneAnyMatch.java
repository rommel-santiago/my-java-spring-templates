package com.sebnsab.demo.playground.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AllNoneAnyMatch {

    public static void main(String[] args) {
        List<String> courses = Arrays.asList( "Java", "JavaScript", "Spring", "React");

        //return false because not all courses starts with Java
        System.out.println(courses.stream().allMatch( c -> c.startsWith("Java")));

        //return false because some courses starts with Java
        System.out.println(courses.stream().noneMatch( c -> c.startsWith("Java")));

        //return true because some courses starts with Java
        System.out.println(courses.stream().anyMatch( c -> c.startsWith("Java")));


    }
}
