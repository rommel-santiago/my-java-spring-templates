package com.sebnsab.demo.service;

import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {ServiceDemo.class})
//@Import({ServiceDemo.class}) this will load the bean but not the properties file
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
