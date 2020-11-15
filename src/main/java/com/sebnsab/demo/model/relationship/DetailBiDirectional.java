package com.sebnsab.demo.model.relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sebnsab.demo.model.relationship.Product;
import com.sebnsab.demo.model.relationship.Transaction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter

public class DetailBiDirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="dateCreated")
    private Date dateCreated;

    @Column(name ="dateModified")
    private Date dateModified;

    // This will create a column called transaction_id which will be join to transaction.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    @JsonIgnore // This will prevent recursive calls when converting to Json
    private Transaction transaction;

    // This will create a column called product_id, which will be joined to the id of product
    @ManyToOne(fetch = FetchType.EAGER) //Set to EAGER to avoid JSON Issues
    @JoinColumn(name = "product_id")
    private Product product;

    public DetailBiDirectional() {
    }

    public DetailBiDirectional(Transaction transaction) {
        this.dateCreated = java.sql.Date.valueOf(LocalDate.now());
        this.dateModified = this.dateCreated;
        this.transaction = transaction;
    }


}
