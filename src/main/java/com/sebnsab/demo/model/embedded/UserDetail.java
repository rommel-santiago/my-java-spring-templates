package com.sebnsab.demo.model.embedded;

import com.sebnsab.demo.model.relationship.DetailBiDirectional;
import com.sebnsab.demo.model.relationship.Product;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserDetail {

    private Long id;
    private Date dateCreated;
    private Date dateModified;
    private Name name;
    private Address address;

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

    @Embedded
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "address", column = @Column(name = "home_address")),
            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "home_zipcode"))
    })
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}


