package com.fintech.loanservice.dao.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Bharathi on 11/09/21.
 */
@Entity
@Table(name = "LOAN_PAYMENT_DETAIL")
public class LoanPaymentDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "LOAN_PAYMENT_DETAIL_ID_SEQ")
    @SequenceGenerator(sequenceName = "LOAN_PAYMENT_DETAIL_ID_SEQ", allocationSize = 1, name = "LOAN_PAYMENT_DETAIL_ID_SEQ")
    private Long id;
    private String description;
    private Double amount;
    private Long borrowerId;
    private Long loanDetailId;
    private Double interest;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getLoanDetailId() {
        return loanDetailId;
    }

    public void setLoanDetailId(Long loanDetailId) {
        this.loanDetailId = loanDetailId;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanPaymentDetail that = (LoanPaymentDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(amount, that.amount) && Objects.equals(borrowerId, that.borrowerId) && Objects.equals(loanDetailId, that.loanDetailId) && Objects.equals(interest, that.interest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, borrowerId, loanDetailId, interest);
    }
}
