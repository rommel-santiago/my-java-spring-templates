package com.sebnsab.demo.playground.lambda;

import com.sebnsab.demo.playground.iz0809.DefaultAccessModifier;
import com.sebnsab.demo.playground.iz0809.ExtendsD;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

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

         *  Finally you can also use Method Reference to further shorten it to be like
         *  MyFirstFunctionalInterface fi =  System.out:println;

         */

                //Then you can just use it like a typically object
        fi.oneAbstractMethod("rommel");


    }

    private static void typicalUsageOfLambda() {

        List<Person1> persons = Arrays.asList(
                new Person1("jeeps"),
                new Person1("rache"),
                new Person1("sebi"),
                new Person1("sab"));

        persons.stream()
                .forEach(a -> a.setRandomNumber(new Random().nextInt()));

        persons.stream()
                .forEach(a -> System.out.println(a.toString()));



    }

    private static void assignNumber(Person1 p, ModifyPerson number) {
        number.assign(p);
    }


}

interface MyFirstFunctionalInterface {
    void oneAbstractMethod(String name);
}

interface ModifyPerson {
    void assign(Person1 person);
}

@Getter
@Setter
@ToString
class Person1 {
    private String name;
    private Integer randomNumber;

    Person1(String name) {
        this.name = name;
    }

}
