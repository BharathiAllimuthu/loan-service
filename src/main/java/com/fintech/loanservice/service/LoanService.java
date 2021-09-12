package com.fintech.loanservice.service;

import com.fintech.loanservice.dao.entity.Borrower;
import com.fintech.loanservice.dao.entity.Investor;
import com.fintech.loanservice.dao.entity.LoanDetail;
import com.fintech.loanservice.dao.entity.LoanParticipationDetail;
import com.fintech.loanservice.model.*;

import java.util.List;

/**
 * @author Bharathi on 11/09/21.
 */
public interface LoanService {

    LoanResponse applyLoan(LoanRequest loanRequest);

    LoanApproveResponse approveLoan(LoanApproveRequest loanApproveRequest);

    LoanParticipationResponse participateLoan(LoanParticipationRequest loanParticipationRequest);

    List<LoanParticipationDetail> findLoansByInvestor(Long investorId);

    List<LoanDetail> findLoansByBorrower(Long borrowerId);

    void updateNoOfInvestors(Long loanId, Integer noOfInvestors);

    void saveInvestor(Investor investor);

    void saveBorrower(Borrower borrower);

    void payLoan(PaymentRequest paymentRequest);

    PaymentDetailResponse getPaymentDetails(Long loanId);
}
