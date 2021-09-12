# loan-service

### **Tech stacks**
- Spring Boot
- Java 8
- Flyway
- Maven
- Spring Data Jpa 
- H2 In-memory DB (commented mysql db info)
- Swagger

### How to Test APIs
http://localhost:8080/swagger-ui.html

## API Info

- /v1/loan-service/apply-loan
- /v1/loan-service/approve-loan
- /v1/loan-service/participate-loan
- /v1/loan-service/find-loans-by-investor/{investorId}
- /v1/loan-service/find-loans-by-borrower/{borrowerId}
- /v1/loan-service/update-number-of-investors/{loanId}/{noOfInvestors}
- /v1/loan-service/pay-loan
- /v1/loan-service/loan-payment-details/{loanId}
- /v1/loan-service/add-borrower
- /v1/loan-service/add-investor