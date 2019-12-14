package com.sebnsab.demo.model;

import org.junit.jupiter.api.Test;

public class LombokModelTest {

    @Test
    public void testLombokGetterAndSetter() {

        LombokModel model = new LombokModel();

        model.setName("blah");
        model.setNumber(Integer.parseInt("34"));

        System.out.println(model.getName());
        System.out.println(model.getNumber());

    }

    @Test
    public void testLombokRequiredArgs() {
        RequiredArgSample s = new RequiredArgSample("rommel");
    }
}
