package com.fintech.loanservice.dao.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Bharathi on 11/09/21.
 */
@Entity
@Table(name = "LOAN_PARTICIPATION_DETAIL")
public class LoanParticipationDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "LOAN_PARTICIPATION_DETAIL_ID_SEQ")
    @SequenceGenerator(sequenceName = "LOAN_PARTICIPATION_DETAIL_ID_SEQ", allocationSize = 1,  name = "LOAN_PARTICIPATION_DETAIL_ID_SEQ")
    private Long id;
    private String description;
    private Double amount;
    private Long investorId;
    private Long loanDetailId;

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

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public Long getLoanDetailId() {
        return loanDetailId;
    }

    public void setLoanDetailId(Long loanDetailId) {
        this.loanDetailId = loanDetailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanParticipationDetail that = (LoanParticipationDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(amount, that.amount) && Objects.equals(investorId, that.investorId) && Objects.equals(loanDetailId, that.loanDetailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, investorId, loanDetailId);
    }
}
