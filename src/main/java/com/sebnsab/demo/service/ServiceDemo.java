package com.sebnsab.demo.service;

import com.sebnsab.demo.enums.ServiceStatus;
import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceDemo {

    @Value("${service.demo.name}")
    private String demoName;

    @Value("${service.demo.replace}")
    private String replace;


    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {

        log.info(String.format("Demo Name is %s",demoName));
        log.info(String.format("Replace Name is %s",replace));

        return transactionRepository.findAll();

    }
}
