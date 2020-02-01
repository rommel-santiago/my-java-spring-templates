package com.sebnsab.demo.others;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Service
public class FileAccessDemo {


    @Autowired
    private ResourceLoader resourceLoader;

    public void openFile() throws IOException {


        Resource resource = resourceLoader.getResource("classpath:files/blah.txt");


        File f = resource.getFile();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            while (br.ready()){
                String line = br.readLine();
                System.out.println(line);
                String[] cols = line.split(",");
                System.out.println(cols);

            }


        }


    }

}
