package com.sebnsab.demo.model.relationship;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Date dateCreated;
    private Date dateModified;


    public Product() {
    }

    public Product(String productName) {
        this.dateCreated = java.sql.Date.valueOf(LocalDate.now());
        this.dateModified = this.dateCreated;
        this.productName = productName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
