package com.fintech.loanservice.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Bharathi on 11/09/21.
 */
@Entity
@Table(name = "LOAN_DETAIL")
public class LoanDetail implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "LOAN_DETAIL_ID_SEQ")
    @SequenceGenerator(sequenceName = "LOAN_DETAIL_ID_SEQ", allocationSize = 1,  name = "LOAN_DETAIL_ID_SEQ")
    private Long id;
    private String description;
    private Double interestRate;
    private Double amount;
    private String tenure;
    private String startDate;
    private String status;
    private Integer noOfInvestors;
    private Long assignedTo;
    private Long approvedBy;

    @ManyToOne
    private Borrower borrower;

    @OneToMany(mappedBy = "loanDetailId")
    private List<LoanParticipationDetail> loanParticipationDetail;

    @OneToMany(mappedBy = "loanDetailId")
    private List<LoanPaymentDetail> loanPaymentDetail;

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

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNoOfInvestors() {
        return noOfInvestors;
    }

    public void setNoOfInvestors(Integer noOfInvestors) {
        this.noOfInvestors = noOfInvestors;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public List<LoanParticipationDetail> getLoanParticipantDetail() {
        return loanParticipationDetail;
    }

    public void setLoanParticipantDetail(List<LoanParticipationDetail> loanParticipationDetail) {
        this.loanParticipationDetail = loanParticipationDetail;
    }

    public List<LoanPaymentDetail> getLoanPaymentDetail() {
        return loanPaymentDetail;
    }

    public void setLoanPaymentDetail(List<LoanPaymentDetail> loanPaymentDetail) {
        this.loanPaymentDetail = loanPaymentDetail;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanDetail that = (LoanDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(interestRate, that.interestRate) && Objects.equals(amount, that.amount) && Objects.equals(tenure, that.tenure) && Objects.equals(startDate, that.startDate) && Objects.equals(status, that.status) && Objects.equals(noOfInvestors, that.noOfInvestors) && Objects.equals(assignedTo, that.assignedTo) && Objects.equals(approvedBy, that.approvedBy) && Objects.equals(borrower, that.borrower) && Objects.equals(loanParticipationDetail, that.loanParticipationDetail) && Objects.equals(loanPaymentDetail, that.loanPaymentDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, interestRate, amount, tenure, startDate, status, noOfInvestors, assignedTo, approvedBy, borrower, loanParticipationDetail, loanPaymentDetail);
    }
}
