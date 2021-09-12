package com.fintech.loanservice.dao.repository;

import com.fintech.loanservice.dao.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bharathi on 11/09/21.
 */
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
