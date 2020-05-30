package com.sebnsab.demo.controller.json;

import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.ProductRepository;
import com.sebnsab.demo.repository.TransactionRepository;
import com.sebnsab.demo.service.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController //@Restcontroller is the same as @Controller except it includes @ResponseBody
public class JsonController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServiceDemo serviceDemo;

    @GetMapping(value = "/tranListing", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> getListing() {

        List<Transaction> transactions = transactionRepository.findAll();
        return transactions;
    }


    @GetMapping(value = "/securedListing", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> getListingSecured() {

        return serviceDemo.getAllTransactions();
    }

    @PutMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody final Product product) {

        Optional<Product> prod = productRepository.findById(productId);

        Product productRecord = prod.orElseThrow(() -> new RuntimeException(String.format("Id does not exist %s", product.getId())));

        productRecord.setProductName(product.getProductName());

        return productRepository.save(productRecord);

    }

    @DeleteMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteProduct(@PathVariable("productId") Long productId) {

        return "Deleted";
    }

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("productId") Long productId) {

        Optional<Product> product = productRepository.findById(productId);

        return product.orElse(null);

    }

    @PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@RequestBody Product product) {

        product.setDateCreated(java.sql.Date.valueOf(LocalDate.now()));
        product.setDateModified(product.getDateCreated());

        return productRepository.save(product);

    }



}
