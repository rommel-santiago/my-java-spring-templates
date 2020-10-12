package com.sebnsab.demo.playground.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviourParameterization {

    public static void main(String[] args) {

        //Behaviour Parameterization Sample With Filter
        List<Integer> numbers = Arrays.asList(5,10,33,15,2,3);

        filterList(numbers, x -> x % 2 == 0); //Print Even numbers
        filterList(numbers, x -> x % 2 != 0); //Print Even numbers

        //Behaviour Parameterization Sample with Map.



    }


    private static void filterList(List<Integer> numbers, Predicate<Integer> predicate) {

        List<Integer> filtered = numbers.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println(filtered);
    }
    
}
