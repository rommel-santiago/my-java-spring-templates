package com.sebnsab.demo.others;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class FileAccessDemo {


    @Autowired
    private ResourceLoader resourceLoader;

    public void openFile(String fileName) throws IOException {


        Resource resource = resourceLoader.getResource(fileName);


        // getSource can be of 3 things below

        //resourceLoader.getResource("classpath:files/blahtest.txt");
        //resourceLoader.getResource("file:/Users/rommel/IdeaProjects/java-spring/pom.xml");
        //resourceLoader.getResource("url:http://www.sda/com/test.txt");

        File f = resource.getFile();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            while (br.ready()){
                String line = br.readLine();
                System.out.println(line);
                String[] cols = line.split(",");
            }


        }


    }

    public Resource[] getListOfResources() throws IOException {

        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:folder/**/*.xml");
        //Resource[] resources = new PathMatchingResourcePatternResolver().getResources("file:folder/**/*.xml");

        return resources;


    }

    public String getFileViaClassPAth() throws  IOException {
        ClassPathResource resource = new ClassPathResource("blah/a_file.txt");

        resource.getFile();
        return null;


    }

}
