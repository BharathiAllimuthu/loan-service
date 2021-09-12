package com.fintech.loanservice.dao.repository;

import com.fintech.loanservice.dao.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bharathi on 11/09/21.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
