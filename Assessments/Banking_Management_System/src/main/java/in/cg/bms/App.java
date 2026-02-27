package in.cg.bms;

import in.cg.services.CustomerService;
import in.cg.services.AccountService;
import in.cg.services.TransactionService;
import in.cg.services.LoanService;
import in.cg.services.ReportService;

public class App {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		AccountService accountService = new AccountService();
		TransactionService transactionService = new TransactionService();
		LoanService loanService = new LoanService();
		ReportService reportService = new ReportService();

		// Register
		customerService.registerCustomer("Madhav", "madhav@email.com", "9876543210");
		System.out.println("Customer Registered");

	
		accountService.createAccount(1L, "SAVINGS", 10000.0); 	// Create Account
		System.out.println("Account Created");

	
		transactionService.deposit(1L, 2000.0);	// Deposit
		System.out.println("Amount Deposited");  

		transactionService.withdraw(1L, 1500.0);
		System.out.println("Amount Withdraw");		// Withdraw


		loanService.applyLoan(1L, 50000.0, "HOME_LOAN");    // Apply Loan
		System.out.println("Loan Applied");  

		// Repo
		reportService.getAllAccounts();

	}
}