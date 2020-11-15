package com.sebnsab.demo.model.relationship;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Column(name = "dateModified")
    private Date dateModified;

    // This is Bidirectional because there is also a @ManyTonOne on DetailBiDirectional Class
    // By Default the child table will be joined on this table's id which is annotated with @Id
    // mappedby is the parent property on the child table
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
    //If you only need to map the column itself not the object
    //You can also just use @Join
    //@JoinColumn(name="columnOnTheManyTable", referencedColumnName="ColumnOnOneTable"
    private Set<DetailBiDirectional> detailBiDirectionals;

    // This is UniDirectional because there is no @ManyTonOne on DetailUniDirectional Class
    // So you have to specify the @JoinColumn
    @OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name="columnOnTheManyTable", referencedColumnName="ColumnOnOneTable"
    @JoinColumn(name="transaction_id", referencedColumnName ="id")
    private Set<DetailUniDirectional> detailUniDirectionals;

    public Transaction() {
        detailBiDirectionals = new HashSet<>();
        detailUniDirectionals = new HashSet<>();
    }


}
