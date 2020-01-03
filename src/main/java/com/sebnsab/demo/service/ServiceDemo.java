package com.sebnsab.demo.service;

import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.ch.ThreadPool;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ServiceDemo {

    @Value("${service.demo.name}")
    private String demoName;

    @Value("${service.demo.replace}")
    private String replace;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        log.info(String.format("Demo Name is %s",demoName));
        log.info(String.format("Replace Name is %s",replace));
        return transactionRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    //Also to work, this method should be called from another bean
    //and should be called directly not indirectly
    //Also check application.properties for the properties required for batching to work
    public List<Product> addProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("blah1"));
        products.add(new Product("blah2"));
        products.add(new Product("blah3"));
        products.add(new Product("blah4"));
        products.add(new Product("blah5"));
        products.add(new Product("blah6"));
        products.add(new Product("blah7"));

        Integer count = 0;

        for( Product product : products) {
            entityManager.persist(product);
            flush(count);
        }

        // No need to flush here

        return null;

    }

    private void flush(Integer count) {
        //This BATCH_SIZE should match spring.jpa.properties.hibernate.jdbc.batch_size = 2000
        //End is needed so it clears up memory.
        int BATCH_SIZE = 2000;

        if (count > 0 && count % BATCH_SIZE == 0) {
            entityManager.flush();
            entityManager.clear();
        }

        count++;

    }

    @Async("threadPoolTaskExecutor")
    public void asyncCallDemo() {

        try {
            log.info("Sleeping..");
            Thread.sleep(5000);
            log.info("awake..");
        } catch(InterruptedException e) {
            log.error("Someone woke me up..");
        }


    }

}
