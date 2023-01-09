package com.sebnsab.demo.playground.other;


import org.apache.commons.lang.StringUtils;

public class IsBlankIsEmpty {

    public static void main (String[] args) {

        String a = "  ";
        String b = "";
        String c = null;
        String d = "asdf";
        

        System.out.println(StringUtils.isNotBlank(a));
        System.out.println(StringUtils.isNotBlank(b));
        System.out.println(StringUtils.isNotBlank(c));
        System.out.println(StringUtils.isNotBlank(d));


    }
}


