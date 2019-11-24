package com.sebnsab.demo.model.lombok;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
