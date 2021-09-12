package com.fintech.loanservice.dao.repository;

import com.fintech.loanservice.dao.entity.LoanPaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Bharathi on 11/09/21.
 */
public interface LoanPaymentDetailRepository extends JpaRepository<LoanPaymentDetail, Long> {

    List<LoanPaymentDetail> findByLoanDetailId(@Param("loanDetailId") Long loanDetailId);
}
