package com.sebnsab.demo.playground.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class BuiltInFunctionalInterface {

    public static void main (String[] args) {

        // Accepts one parameter of a certain type and returns an object of the same type
        UnaryOperator<String> unaryOperator = x -> x.concat("_blah");
        System.out.println(unaryOperator.apply("first"));

        // Accepts 2 parameters of a certain type and returns an object of the same type
        BinaryOperator<Integer> binaryOperator = (x,y) -> x + y;
        System.out.println(binaryOperator.apply(5,10));

        //Accepts 2 parameters of certain type and returns a boolean
        Predicate<String> predicate = (x) -> x.equals("test");
        System.out.println(predicate.test("notTest"));



    }



}


