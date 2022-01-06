package com.sebnsab.demo.patterns;

public class SingletonClass {

    private static volatile SingletonClass singletonClass = null;

    private SingletonClass() {
        // Just in case someone instantiates via reflection
        if (singletonClass != null) throw new RuntimeException("There can be one instance");


    }

    public static SingletonClass getInstance() {

        if (singletonClass == null) {
            synchronized (SingletonClass.class) {
                if (singletonClass == null) singletonClass = new SingletonClass();
            }
        }

        return singletonClass;
    }


}