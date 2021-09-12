package com.fintech.loanservice.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Bharathi on 11/09/21.
 */
@Entity
public class Borrower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BORROWER_ID_SEQ")
    @SequenceGenerator(sequenceName = "BORROWER_ID_SEQ", allocationSize = 1, name = "BORROWER_ID_SEQ")
    private Long id;
    private String name;
    private String mobile;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrower borrower = (Borrower) o;
        return Objects.equals(id, borrower.id) && Objects.equals(name, borrower.name) && Objects.equals(mobile, borrower.mobile) && Objects.equals(address, borrower.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobile, address);
    }
}
