package com.fintech.loanservice.model;

/**
 * @author Bharathi on 11/09/21.
 */
public class LoanParticipationResponse {

    private Long investorId;
    private Long loanId;
    private Double amount;
    private String message;

    public LoanParticipationResponse() {
    }

    public LoanParticipationResponse(Long investorId, Long loanId, Double amount, String message) {
        this.investorId = investorId;
        this.loanId = loanId;
        this.amount = amount;
        this.message = message;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
