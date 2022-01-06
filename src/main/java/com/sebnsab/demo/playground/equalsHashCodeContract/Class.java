package com.sebnsab.demo.playground.equalsHashCodeContract;

import java.util.HashSet;

public class Class {
    public static void main(String[] args) {
        HashSet<Pojo> pojos = new HashSet<>();


        pojos.add(new Pojo("a","asdf"));
        pojos.add(new Pojo("b","666"));
        pojos.add(new Pojo("a","45645"));
        pojos.add(new Pojo("a","4565"));


    }

}
