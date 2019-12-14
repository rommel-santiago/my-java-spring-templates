package com.sebnsab.demo.model.relationship;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateCreated;
    private Date dateModified;

    // This is Bidirectional because there is also a @ManyTonOne on DetailBiDirectional Class
    // By Default the child table will be joined on this table's id which is annotated with @Id
    // mappedby is the parent property on the child table
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
    private Set<DetailBiDirectional> detailBiDirectionals;

    // This is UniDirectional because there is no @ManyTonOne on DetailUniDirectional Class
    // By Default the child table will be joined on this table's id which is annotated with @Id
    @OneToMany(fetch = FetchType.LAZY)
    private Set<DetailUniDirectional> detailUniDirectionals;

    public Transaction() {
        detailBiDirectionals = new HashSet<>();
        detailUniDirectionals = new HashSet<>();
    }

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

    public Set<DetailBiDirectional> getDetailBiDirectionals() {
        return detailBiDirectionals;
    }

    public void setDetailBiDirectionals(Set<DetailBiDirectional> detailBiDirectionals) {
        this.detailBiDirectionals = detailBiDirectionals;
    }

    public Set<DetailUniDirectional> getDetailUniDirectionals() {
        return detailUniDirectionals;
    }

    public void setDetailUniDirectionals(Set<DetailUniDirectional> detailUniDirectionals) {
        this.detailUniDirectionals = detailUniDirectionals;
    }

}
