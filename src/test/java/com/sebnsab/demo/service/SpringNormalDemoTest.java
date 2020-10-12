package com.sebnsab.demo.service;

import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Import(ServiceDemo.class)
@PropertySource(value = {"classpath:application-test.properties","classpath:application.yml"})
public class SpringNormalDemoTest {


    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private EntityManager entityManager;

    @Autowired
    private ServiceDemo serviceDemo;

    @Test
    public void getAllTransactionTest() {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction());
        transactions.add(new Transaction());
        transactions.add(new Transaction());


        Mockito.when(transactionRepository.findAll()).thenReturn(transactions);
        serviceDemo.getAllTransactions();
    }

}
