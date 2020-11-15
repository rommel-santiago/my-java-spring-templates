package com.sebnsab.demo.model.relationship;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
public class DetailUniDirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Column(name = "dateModified")
    private Date dateModified;

    @Column(name = "transaction_id")
    private Long transaction_id;

    public DetailUniDirectional() {
    }

    public DetailUniDirectional(Long transactionId) {
        this.dateCreated = java.sql.Date.valueOf(LocalDate.now());
        this.dateModified = this.dateCreated;
        this.transaction_id = transactionId;
    }

}
