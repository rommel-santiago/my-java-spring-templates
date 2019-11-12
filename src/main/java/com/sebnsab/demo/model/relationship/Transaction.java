package com.sebnsab.demo.model.relationship;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Transaction {

    private Long id;
    private String description;
    private Date dateCreated;
    private Date dateModified;
    private Set<DetailBiDirectional> detailBiDirectionals;
    private Set<DetailUniDirectional> detailUniDirectionals;

    public Transaction() {
        detailBiDirectionals = new HashSet<>();
        detailUniDirectionals = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @OneToMany(fetch = FetchType.LAZY)    // This is Bidirectional because there is also a @ManyTonOne on DetailBiDirectional Class
    @JoinColumn(name = "transaction_id")  // This is id of Transaction Class that will be created on the Child Table
    public Set<DetailBiDirectional> getDetailBiDirectionals() {
        return detailBiDirectionals;
    }

    public void setDetailBiDirectionals(Set<DetailBiDirectional> detailBiDirectionals) {
        this.detailBiDirectionals = detailBiDirectionals;
    }


    @OneToMany(fetch = FetchType.LAZY)    // This is UniDirectional because there is no @ManyTonOne on DetailUniDirectional Class
    @JoinColumn(name = "transaction_id")  // This is id of Transaction Class that will be created on the Child Table
    public Set<DetailUniDirectional> getDetailUniDirectionals() {
        return detailUniDirectionals;
    }

    public void setDetailUniDirectionals(Set<DetailUniDirectional> detailUniDirectionals) {
        this.detailUniDirectionals = detailUniDirectionals;
    }

}
