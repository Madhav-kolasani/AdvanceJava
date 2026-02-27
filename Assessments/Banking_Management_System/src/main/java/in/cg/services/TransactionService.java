package in.cg.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.cg.entities.*;
import in.cg.util.HibernateUtil;

public class TransactionService {

    public void deposit(Long accountId, double amount) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Account account = session.get(Account.class, accountId);

        if (account == null) {
            System.out.println("Account not found");
            tx.rollback();
            session.close();
            return;
        }

        account.setBalance(account.getBalance() + amount);

        TransactionEntity transaction = new TransactionEntity();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactionType("DEPOSIT");
        transaction.setTransactionDate("NOW");   

        session.persist(transaction);

        tx.commit();
        session.close();
    }

    public void withdraw(Long accountId, double amount) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Account account = session.get(Account.class, accountId);

        if (account == null || account.getBalance() < amount) {
            System.out.println("Insufficient balance or account not found");
            tx.rollback();
            session.close();
            return;
        }

        account.setBalance(account.getBalance() - amount);

        TransactionEntity transaction = new TransactionEntity();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setTransactionType("WITHDRAW");
        transaction.setTransactionDate("NOW");

        session.persist(transaction);

        tx.commit();
        session.close();
    }
}