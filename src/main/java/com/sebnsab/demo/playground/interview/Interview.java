package com.sebnsab.demo.playground.interview;

import java.util.Comparator;

public class Interview {

    public static void main(String[] args) {
        String t;


    }

    private interface blah {
        public void boo();
    }
    private interface blah2 {
        public void boo();
    }
    private class too implements  blah, blah2 {

        @Override
        public void boo() {

        }
    }
    private class comparrammatta implements Comparable<String> {


        @Override
        public int compareTo(String o) {
            return 0;
        }
    }
}
