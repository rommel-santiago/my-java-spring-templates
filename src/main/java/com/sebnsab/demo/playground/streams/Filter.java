package com.sebnsab.demo.playground.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        List<String> names = Arrays.asList( "Zebra","Lamp","Calendar","Glasses","Photos","Socks");
        HashSet<String> blockListed = new HashSet<>();
        Collections.addAll(blockListed,"Zebra","Socks");



        List<String> valid = names.stream()
                .filter(x -> !blockListed.contains(x))
                .collect(Collectors.toList());

        System.out.println(names);
        System.out.println(valid);


    }
}
