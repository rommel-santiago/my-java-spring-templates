package com.sebnsab.demo.others;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import java.util.Set;

public class MultiMapDemo {

    public static void main(String[] args) {
        SetMultimap<Integer,String> mmap = HashMultimap.create();

        mmap.put(1,"one");
        mmap.put(1,"isa");

        Set<String> g = mmap.get(0);

        System.out.println(mmap);
    }


}
