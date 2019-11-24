package com.sebnsab.demo.model.relationship;

import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.model.relationship.Transaction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class DetailBiDirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateCreated;
    private Date dateModified;

    @ManyToOne(fetch = FetchType.LAZY) //This will always automatically create transaction_id column, which will join to  Transaction Class Id because its annotated with @Id
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY) //This will always automatically create product_id column, which will to  Product Class Id because its annotated with @Id
    private Product product;


    public DetailBiDirectional() {
    }

    public DetailBiDirectional(Transaction transaction) {
        this.dateCreated = java.sql.Date.valueOf(LocalDate.now());
        this.dateModified = this.dateCreated;
        this.transaction = transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
