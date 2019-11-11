package com.sebnsab.demo.service;

import com.sebnsab.demo.model.DetailBiDirectional;
import com.sebnsab.demo.model.DetailUniDirectional;
import com.sebnsab.demo.model.Product;
import com.sebnsab.demo.model.Transaction;
import com.sebnsab.demo.repository.DetailBiDirectionalRepository;
import com.sebnsab.demo.repository.DetailUniDirectionalRepository;
import com.sebnsab.demo.repository.ProductRepository;
import com.sebnsab.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private DetailBiDirectionalRepository detailBiDirectionalRepository;

    @Autowired
    private DetailUniDirectionalRepository detailUniDirectionalRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeData();
    }

    private void initializeData() {

        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");

        productRepository.save(product1);
        productRepository.save(product2);


        Transaction tran1 = new Transaction();

        tran1.setDescription("First Transaction");
        tran1.setDateCreated(java.sql.Date.valueOf(LocalDate.now()));
        tran1.setDateModified(tran1.getDateCreated());
        transactionRepository.save(tran1);

        DetailBiDirectional dbd1 = new DetailBiDirectional(tran1);
        DetailBiDirectional dbd2 = new DetailBiDirectional(tran1);

        dbd1.setProduct(product1);
        dbd1.setProduct(product2);




        detailBiDirectionalRepository.save(dbd1);
        detailBiDirectionalRepository.save(dbd2);

        detailUniDirectionalRepository.save(new DetailUniDirectional(tran1.getId()));
        detailUniDirectionalRepository.save(new DetailUniDirectional(tran1.getId()));


        Transaction retrieved = transactionRepository.getById(1L);

        System.out.println(retrieved);





    }
}
