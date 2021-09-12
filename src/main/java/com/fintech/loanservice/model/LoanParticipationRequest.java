package com.fintech.loanservice.model;

/**
 * @author Bharathi on 11/09/21.
 */
public class LoanParticipationRequest {

    private Long loanId;
    private Long investorId;
    private Double amount;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
