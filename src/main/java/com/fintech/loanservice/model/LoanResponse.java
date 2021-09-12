package com.fintech.loanservice.model;

/**
 * @author Bharathi on 11/09/21.
 */
public class LoanResponse {

    private Long loanId;
    private String assignedTo;
    private String contact;
    private String message;


    public LoanResponse(Long loanId, String assignedTo, String contact, String message) {
        this.loanId = loanId;
        this.assignedTo = assignedTo;
        this.contact = contact;
        this.message = message;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
