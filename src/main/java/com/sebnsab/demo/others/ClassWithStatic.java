package com.sebnsab.demo.others;

public class ClassWithStatic {
    private static String blah;

    public String getBlah() {
       return blah;
    }

    public  void setBlah(String blah) {
        ClassWithStatic.blah = blah;
    }
}
