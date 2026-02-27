package in.cg.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.cg.entities.Customer;
import in.cg.entities.Loan;
import in.cg.util.HibernateUtil;

public class LoanService {

    public void applyLoan(Long customerId, double amount, String loanType) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, customerId);

        if (customer == null) {
            System.out.println("Customer not found");
            tx.rollback();
            session.close();
            return;
        }

        Loan loan = new Loan();
        loan.setCustomer(customer);
        loan.setAmount(amount);
        loan.setLoanType(loanType);
        loan.setStatus("PENDING");

        session.persist(loan);

        tx.commit();
        session.close();
    }
}