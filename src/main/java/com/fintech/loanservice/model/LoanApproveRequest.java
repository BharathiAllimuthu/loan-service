package com.fintech.loanservice.model;

/**
 * @author Bharathi on 11/09/21.
 */
public class LoanApproveRequest {

    private Long loanId;
    private Long employeeId;
    private String status;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
