package com.sebnsab.demo.others;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@ConditionalOnExpression("${load.bean}")  // You can also use SPEL Expression here
@Component
public class ConditionalBean {

    public ConditionalBean() {
        System.out.println("Bean Loaded because load.bean was set to true ");
        System.out.println( "Other Annotations: \r\n" +
        "@ConditionalOnBean \r\n" +
        "@ConditionalOnClass \r\n" +
        "@ConditionalOnJava \r\n" +
        "@ConditionalOnMissingBean \r\n" +
        "@ConditionalOnMissingClass \r\n" +
        "@ConditionalOnNotWebApplication \r\n" +
        "@ConditionalOnProperty \r\n" +
        "@ConditionalOnResource \r\n" +
        "@ConditionalOnWebApplication \r\n");
    }
}
