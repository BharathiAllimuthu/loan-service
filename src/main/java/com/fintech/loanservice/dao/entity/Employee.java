package com.fintech.loanservice.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Bharathi on 11/09/21.
 */
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_SEQ")
    @SequenceGenerator(sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1,  name = "EMPLOYEE_ID_SEQ")
    private Long id;
    private String name;
    private String mobile;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(mobile, employee.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobile);
    }
}
