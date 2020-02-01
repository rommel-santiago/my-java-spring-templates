package com.sebnsab.demo.service;

import com.sebnsab.demo.config.ConfigDemo;
import com.sebnsab.demo.others.RetryDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ConfigDemo.class, RetryDemo.class})
public class RetryDemoTest {

    @Autowired
    private RetryDemo retryDemo;

    @Test
    public void retryDemoTest() {

        retryDemo.methodToRetry("input baby");

    }
}
