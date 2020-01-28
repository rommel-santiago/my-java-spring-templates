package com.sebnsab.demo.service;

import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
//This is faster but does not load the properties.
public class MockitoDemoTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
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
