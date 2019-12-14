package com.sebnsab.demo.service;

import com.sebnsab.demo.repository.TransactionRepository;
import com.sebnsab.demo.service.ServiceDemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {ServiceDemo.class})
@ActiveProfiles("test")
public class ServiceDemoTest {

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private ServiceDemo serviceDemo;

    @Test
    public void getAllTransactionTest() {

        serviceDemo.getAllTransactions();


    }


}
