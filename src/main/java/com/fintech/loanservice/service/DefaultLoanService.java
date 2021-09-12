package com.fintech.loanservice.service;

import com.fintech.loanservice.dao.entity.*;
import com.fintech.loanservice.dao.repository.*;
import com.fintech.loanservice.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bharathi on 12/09/21.
 */
@Service
public class DefaultLoanService implements LoanService {

    private final BorrowerRepository borrowerRepository;
    private final InvestorRepository investorRepository;
    private final LoanDetailRepository loanDetailRepository;
    private final EmployeeRepository employeeRepository;
    private final LoanParticipationDetailRepository loanParticipationDetailRepository;
    private final LoanPaymentDetailRepository loanPaymentDetailRepository;

    public DefaultLoanService(final BorrowerRepository borrowerRepository,
                              final InvestorRepository investorRepository,
                              final LoanDetailRepository loanDetailRepository,
                              final EmployeeRepository employeeRepository,
                              final LoanParticipationDetailRepository loanParticipationDetailRepository,
                              final LoanPaymentDetailRepository loanPaymentDetailRepository) {

        this.borrowerRepository = borrowerRepository;
        this.investorRepository = investorRepository;
        this.loanDetailRepository = loanDetailRepository;
        this.employeeRepository = employeeRepository;
        this.loanParticipationDetailRepository = loanParticipationDetailRepository;
        this.loanPaymentDetailRepository = loanPaymentDetailRepository;
    }

    @Override
    public LoanResponse applyLoan(LoanRequest loanRequest) {

        LoanDetail loanDetail = new LoanDetail();
        loanDetail.setAmount(loanRequest.getAmount());
        Employee employee = Optional.of(employeeRepository.findAll())
            .filter(it -> !it.isEmpty())
            .flatMap(it -> it.stream().findFirst())
            .orElseThrow(() -> new RuntimeException("No employees available to assign"));

        loanDetail.setStatus(LoanStatus.INITIATED.getStatus());
        loanDetail.setInterestRate(loanRequest.getInterest());
        loanDetail.setDescription("Loan request of " + loanRequest.getAmount());
        loanDetail.setAssignedTo(employee.getId());
        loanDetail.setTenure(loanRequest.getTenure());
        loanDetail.setBorrower(borrowerRepository.findById(loanRequest.getBorrowerId()).orElseThrow(() -> new RuntimeException("")));
        loanDetailRepository.save(loanDetail);

        return new LoanResponse(loanDetail.getId(), employee.getName(), employee.getMobile(), "Loan request initiated");
    }

    @Override
    public LoanApproveResponse approveLoan(final LoanApproveRequest loanApproveRequest) {
        final LoanDetail loanDetail = loanDetailRepository.findById(loanApproveRequest.getLoanId()).orElseThrow(RuntimeException::new);

        final double sumOfInvestorsAmount = loanDetail.getLoanParticipantDetail()
            .stream()
            .mapToDouble(LoanParticipationDetail::getAmount)
            .sum();

        if (sumOfInvestorsAmount < loanDetail.getAmount()) {
            loanDetail.setStatus(LoanStatus.PENDING.getStatus());
            loanDetailRepository.save(loanDetail);

            throw new RuntimeException("Requested loan amount not available - still investors needs to be participate to fulfill the requested loan amount");
        }

        loanDetail.setApprovedBy(loanApproveRequest.getEmployeeId());
        loanDetail.setStatus(LoanStatus.lookup(loanApproveRequest.getStatus()).getStatus());

        loanDetailRepository.save(loanDetail);

        LoanApproveResponse loanApproveResponse = new LoanApproveResponse();
        loanApproveResponse.setLoanId(loanApproveRequest.getLoanId());
        loanApproveResponse.setDescription("Loan Approved");
        loanApproveResponse.setLoanParticipantDetails(loanParticipationDetailRepository.findByLoanDetailId(loanDetail.getId()));
        return loanApproveResponse;

    }

    @Override
    public LoanParticipationResponse participateLoan(LoanParticipationRequest loanParticipationRequest) {

        final LoanParticipationDetail loanParticipationDetail = new LoanParticipationDetail();
        loanParticipationDetail.setLoanDetailId(loanParticipationRequest.getLoanId());
        loanParticipationDetail.setAmount(loanParticipationRequest.getAmount());
        loanParticipationDetail.setInvestorId(loanParticipationRequest.getInvestorId());
        loanParticipationDetail.setDescription("Invested Rs. " + loanParticipationRequest.getAmount() + " for loan Id : " + loanParticipationRequest.getLoanId());
        loanParticipationDetailRepository.save(loanParticipationDetail);

        return new LoanParticipationResponse(loanParticipationDetail.getInvestorId(), loanParticipationDetail.getLoanDetailId(), loanParticipationDetail.getAmount(), loanParticipationDetail.getDescription());
    }

    @Override
    public List<LoanParticipationDetail> findLoansByInvestor(Long investorId) {

        return loanParticipationDetailRepository.findByInvestorId(investorId);
    }

    @Override
    public List<LoanDetail> findLoansByBorrower(Long borrowerId) {

        Borrower borrower = borrowerRepository.findById(borrowerId).orElseThrow(() -> new RuntimeException("No borrower found.."));
        return loanDetailRepository.findByBorrower(borrower);
    }

    @Override
    public void updateNoOfInvestors(Long loanId, Integer noOfInvestors) {
        LoanDetail loanDetail = loanDetailRepository.findById(loanId).orElseThrow(RuntimeException::new);
        loanDetail.setNoOfInvestors(noOfInvestors);

        loanDetailRepository.save(loanDetail);
    }

    @Override
    public void saveInvestor(Investor investor) {
        investorRepository.save(investor);
    }

    @Override
    public void saveBorrower(Borrower borrower) {
        borrowerRepository.save(borrower);
    }

    @Override
    public void payLoan(PaymentRequest paymentRequest) {
        loanDetailRepository.findById(paymentRequest.getLoanId()).orElseThrow(RuntimeException::new);

        LoanPaymentDetail loanPaymentDetail = new LoanPaymentDetail();
        loanPaymentDetail.setLoanDetailId(paymentRequest.getLoanId());
        loanPaymentDetail.setBorrowerId(paymentRequest.getBorrowerId());
        loanPaymentDetail.setAmount(paymentRequest.getAmount());
        loanPaymentDetail.setDescription(paymentRequest.getPaymentType());
        loanPaymentDetailRepository.save(loanPaymentDetail);
    }

    @Override
    public PaymentDetailResponse getPaymentDetails(Long loanId) {
        LoanDetail loanDetail = loanDetailRepository.findById(loanId).orElseThrow(RuntimeException::new);
        List<LoanPaymentDetail> paymentDetails = loanPaymentDetailRepository.findByLoanDetailId(loanId);

        double paidAmount = paymentDetails
            .stream()
            .mapToDouble(LoanPaymentDetail::getAmount)
            .sum();

        double paidInterest = paymentDetails
            .stream()
            .mapToDouble(LoanPaymentDetail::getInterest)
            .sum();


        PaymentDetailResponse paymentDetailResponse = new PaymentDetailResponse();
        paymentDetailResponse.setLoanId(loanId);
        paymentDetailResponse.setPaidAmount(paidAmount);
        paymentDetailResponse.setPrinciple(loanDetail.getAmount());
        paymentDetailResponse.setPaidInterest(paidInterest);
        paymentDetailResponse.setLoanStatus(LoanStatus.lookup(loanDetail.getStatus()));

        return paymentDetailResponse;
    }
}
