package com.fintech.loanservice.dao.repository;

import com.fintech.loanservice.dao.entity.Borrower;
import com.fintech.loanservice.dao.entity.LoanDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Bharathi on 11/09/21.
 */
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Long> {


    List<LoanDetail> findByBorrower(Borrower borrower);

}
