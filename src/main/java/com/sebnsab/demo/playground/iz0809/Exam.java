package com.sebnsab.demo.playground.iz0809;

import java.io.IOException;

public class Exam {

    public static void main(String[] args) throws IOException {

        //Default Access Modifier Check
        ExtendsD d = new ExtendsD();
        System.out.println(d.blah);

        CompareCheck a = new CompareCheck(101, "Java Programming");
        CompareCheck b = new CompareCheck(102, "Java Programming");

        try {
            new Game().play();
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }



    }
}

class Video {
    public void play() throws IOException {
        System.out.println("Video played.");
    }
}

class Game extends Video {
    public void play() throws IOException {
        super.play();
        System.out.println("Game played.");
    }
}

