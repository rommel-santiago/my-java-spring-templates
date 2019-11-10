package com.sebnsab.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class DetailBiDirectional {

    private Long id;
    private Date dateCreated;
    private Date dateModified;
    private Transaction transaction;


    public DetailBiDirectional() {
    }

    public DetailBiDirectional(Transaction transaction) {
        this.dateCreated = java.sql.Date.valueOf(LocalDate.now());
        this.dateModified = this.dateCreated;
        this.transaction = transaction;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @ManyToOne(fetch = FetchType.LAZY) //This will always be join on the Detail Class Id because its annotated with @Id
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
