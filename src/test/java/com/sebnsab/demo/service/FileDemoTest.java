package com.sebnsab.demo.service;

import com.sebnsab.demo.others.FileAccessDemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@SpringBootTest( classes = {FileAccessDemo.class})
public class FileDemoTest {

    @Autowired
    private FileAccessDemo fileAccessDemo;

    @Test
    public void fileDemoTest() throws IOException {

        fileAccessDemo.openFile("classpath:files/blahtest.txt");
        fileAccessDemo.openFile("file:/Users/rommel/IdeaProjects/java-spring/pom.xml");

        //You can also do something like fileAccessDemo.openFile(url:http://www.sda/com/test.txt");

    }

}
