package com.sebnsab.demo.playground.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    public static void main(String[] args) {

        List<String> names = Arrays.asList( "Zebra","Lamp","Calendar","Glasses","Photos","Socks");

        List<String> sortedNames = names.stream()
                .sorted().collect(Collectors.toList());

        System.out.println(sortedNames);
    }
}
