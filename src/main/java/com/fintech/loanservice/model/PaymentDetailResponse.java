package com.fintech.loanservice.model;

/**
 * @author Bharathi on 12/09/21.
 */
public class PaymentDetailResponse {

    private Long loanId;
    private Double principle;
    private Double paidInterest;
    private Double paidAmount;
    private LoanStatus loanStatus;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Double getPrinciple() {
        return principle;
    }

    public void setPrinciple(Double principle) {
        this.principle = principle;
    }

    public Double getPaidInterest() {
        return paidInterest;
    }

    public void setPaidInterest(Double paidInterest) {
        this.paidInterest = paidInterest;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
