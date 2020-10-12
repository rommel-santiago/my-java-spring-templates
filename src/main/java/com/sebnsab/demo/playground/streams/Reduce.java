package com.sebnsab.demo.playground.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce {

    public static void main(String[] args) {

        List<String> courses = Arrays.asList( "Java", "JavaScript", "Spring", "React");

        //Get Longest String
        System.out.println(courses.stream().reduce( (x,y) -> {  return x.length() >= y.length() ? x :  y; }).get());

        //Concat All String
        System.out.println(courses.stream().reduce( (x,y) -> x.concat(" ").concat(y)).get());


        List<Integer> numbers = Arrays.asList( 10, 22, 55, 100);


        Integer total = numbers.stream()
                .reduce( (x,y) -> Integer.sum(x,y)).get();

        System.out.println(total);




    }
}
