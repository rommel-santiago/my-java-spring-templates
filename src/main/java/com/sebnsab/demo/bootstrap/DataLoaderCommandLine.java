package com.sebnsab.demo.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoaderCommandLine implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        //args is the argument passed when you run the app via java.
        log.info("passing through command line runner");
    }
}
