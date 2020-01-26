package com.sebnsab.demo.others;

import com.sebnsab.demo.model.relationship.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TransactionalDemo {

    @Autowired
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    //Also to work, this method should be called from another bean, Most likely from a Controller bean or another Service Bean
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
}
