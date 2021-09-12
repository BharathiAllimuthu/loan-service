package com.fintech.loanservice.dao.repository;

import com.fintech.loanservice.dao.entity.LoanParticipationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Bharathi on 11/09/21.
 */
public interface LoanParticipationDetailRepository extends JpaRepository<LoanParticipationDetail, Long> {

    List<LoanParticipationDetail> findByLoanDetailId(@Param("loanDetailId") Long loanDetailId);

    List<LoanParticipationDetail> findByInvestorId(@Param("investorId") Long investorId);

}
