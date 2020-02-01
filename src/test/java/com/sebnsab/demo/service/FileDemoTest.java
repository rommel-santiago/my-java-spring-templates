package com.sebnsab.demo.service;

import com.sebnsab.demo.others.FileAccessDemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@SpringBootTest(classes = {FileAccessDemo.class})
public class FileDemoTest {

    @Autowired
    private FileAccessDemo fileAccessDemo;

    @Test
    public void fileDemoTest() throws IOException {


        fileAccessDemo.openFile();


    }

}
