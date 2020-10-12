package com.sebnsab.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes =  {ProdTestRepository.class})
@EnableJpaRepositories
public class DetailUniDirectionalRepositoryTest {

    @Autowired
    private ProdTestRepository prodTestRepository;

    @Test
    public void test() {
        prodTestRepository.findAll();
    }
}
