package com.fintech.loanservice.model;

import java.util.Arrays;

/**
 * @author Bharathi on 12/09/21.
 */
public enum LoanStatus {

    INITIATED("Initiated"),
    APPROVED("Approved"),
    PENDING("Pending"),
    COMPLETED("Completed");

    private final String status;

    LoanStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static LoanStatus lookup(String status) {
        return Arrays.stream(LoanStatus.values())
            .filter(loanStatus -> loanStatus.getStatus().equalsIgnoreCase(status))
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }
}
