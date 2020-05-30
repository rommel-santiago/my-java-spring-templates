package com.sebnsab.demo.service;

import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
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

    //@Secured("ROLE_USER")
    //@PreAuthorize("hasRole('USER')")
    //@Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Transaction> getAllTransactions() {
        log.info(String.format("Demo Name is %s",demoName));
        log.info(String.format("Replace Name is %s",replace));
        return transactionRepository.findAll();
    }


}
