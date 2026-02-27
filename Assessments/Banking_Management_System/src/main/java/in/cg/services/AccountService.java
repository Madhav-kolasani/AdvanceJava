package in.cg.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.cg.entities.Account;
import in.cg.entities.Customer;
import in.cg.util.HibernateUtil;

public class AccountService {

    public void createAccount(Long customerId, String accountType, double initialBalance) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, customerId);

        if (customer == null) {
            System.out.println("Customer not found");
            tx.rollback();
            session.close();
            return;
        }

        Account account = new Account();
        account.setAccountType(accountType);
        account.setBalance(initialBalance);
        account.setCustomer(customer);

        session.persist(account);

        tx.commit();
        session.close();
    }
}