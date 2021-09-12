package com.fintech.loanservice.model;

import com.fintech.loanservice.dao.entity.LoanParticipationDetail;

import java.util.List;

/**
 * @author Bharathi on 11/09/21.
 */
public class LoanApproveResponse {


    private Long loanId;
    private String description;
    private String status;
    private String approvedBy;
    private List<LoanParticipationDetail> loanParticipationDetails;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public List<LoanParticipationDetail> getLoanParticipantDetails() {
        return loanParticipationDetails;
    }

    public void setLoanParticipantDetails(List<LoanParticipationDetail> loanParticipationDetails) {
        this.loanParticipationDetails = loanParticipationDetails;
    }
}
