package com.sebnsab.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class DetailUniDirectional {

    private Long id;
    private Date dateCreated;
    private Date dateModified;
    private Long transaction_id;

    public DetailUniDirectional() {
    }

    public DetailUniDirectional(Long transactionId) {
        this.dateCreated = java.sql.Date.valueOf(LocalDate.now());
        this.dateModified = this.dateCreated;
        this.transaction_id = transactionId;
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

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }
}
