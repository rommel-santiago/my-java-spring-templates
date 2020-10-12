package com.sebnsab.demo.playground.lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MyFirstLambda {

    public static void main(String[] args) {
        myFirstLambdaExpression();
        typicalUsageOfLambda();

    }

    private static void myFirstLambdaExpression() {

        //Notice Iam creating an object by just passing the method via lambda expression
        MyFirstFunctionalInterface fi =  (n) -> System.out.println(n);

        /**
         *  Explanation of the above lambda expression is as follows
         *
         *  MyFirstFunctionalInterface fi =  public void oneAbstractMethod (String n) {
         *                                      System.out.println(n);
         *                                   }
         *
         *  Which can be shortened as Lambda expression:
         *  MyFirstFunctionalInterface fi =  (String n) -> { System.out.println(n); }
         *
         *  Which can be further shortened as
         *  MyFirstFunctionalInterface fi =  (n) -> { System.out.println(n); }
         *
         *  And since its a single line code can be further shortened:
         *  MyFirstFunctionalInterface fi =  (n) -> System.out.println(n);
         */

        //Then you can just use it like a typically object
        fi.oneAbstractMethod("rommel");


    }

    private static void typicalUsageOfLambda() {

        List<Person> persons = Arrays.asList(
                new Person("jeeps"),
                new Person("rache"),
                new Person("sebi"),
                new Person("sab"));

        for (Person p : persons) {
            assignNumber(p, a -> a.setRandomNumber(new Random().nextInt()));
            System.out.println(p.toString());
        }


    }

    private static void assignNumber(Person p, modifyPerson number) {
        number.assign(p);
    }


}

interface MyFirstFunctionalInterface {
    void oneAbstractMethod(String name);
}

interface modifyPerson {
    void assign(Person person);
}

@Getter
@Setter
@ToString
class Person {
    private String name;
    private Integer randomNumber;

    Person(String name) {
        this.name = name;
    }

}
