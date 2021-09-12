package com.fintech.loanservice.controller;

import com.fintech.loanservice.dao.entity.Borrower;
import com.fintech.loanservice.dao.entity.Investor;
import com.fintech.loanservice.dao.entity.LoanDetail;
import com.fintech.loanservice.dao.entity.LoanParticipationDetail;
import com.fintech.loanservice.model.*;
import com.fintech.loanservice.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bharathi on 11/09/21.
 */
@RestController
@RequestMapping("/v1/loan-service")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/apply-loan")
    public LoanResponse applyLoan(@RequestBody LoanRequest loanRequest) {
        return loanService.applyLoan(loanRequest);
    }

    @PostMapping("/approve-loan")
    public LoanApproveResponse approveLoan(@RequestBody LoanApproveRequest loanApproveRequest) {
        return loanService.approveLoan(loanApproveRequest);
    }

    @PostMapping("/participate-loan")
    public LoanParticipationResponse participateLoan(@RequestBody LoanParticipationRequest loanParticipationRequest) {
        return loanService.participateLoan(loanParticipationRequest);
    }

    @GetMapping("/find-loans-by-investor/{investorId}")
    public List<LoanParticipationDetail> findLoansByInvestor(@PathVariable("investorId") Long investorId) {
        return loanService.findLoansByInvestor(investorId);
    }

    @GetMapping("/find-loans-by-borrower/{borrowerId}")
    public List<LoanDetail> findLoansByBorrower(@PathVariable("borrowerId") Long borrowerId) {
        return loanService.findLoansByBorrower(borrowerId);
    }

    @PostMapping("/update-number-of-investors/{loanId}/{noOfInvestors}")
    public ResponseEntity<String> updateNoOfInvestors(@PathVariable("loanId") Long loanId,
                                                      @PathVariable("noOfInvestors") Integer noOfInvestors) {

        loanService.updateNoOfInvestors(loanId, noOfInvestors);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @PostMapping("/pay-loan")
    public ResponseEntity<String> payLoan(@RequestBody PaymentRequest paymentRequest) {
        loanService.payLoan(paymentRequest);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @GetMapping("/loan-payment-details/{loanId}")
    public PaymentDetailResponse getPaymentDetailsByLoanId(@PathVariable("loanId") Long loanId) {
        return loanService.getPaymentDetails(loanId);
    }

    @PutMapping("/add-borrower")
    public ResponseEntity<String> addBorrower(@RequestBody Borrower borrower) {
        loanService.saveBorrower(borrower);
        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }

    @PutMapping("/add-investor")
    public ResponseEntity<String> addInvestor(@RequestBody Investor investor) {
        loanService.saveInvestor(investor);
        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }
}
