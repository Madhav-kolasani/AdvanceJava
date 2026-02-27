package in.cg.services;

import org.hibernate.Session;
import in.cg.entities.Account;
import in.cg.util.HibernateUtil;

import java.util.List;

public class ReportService {

	public void getAllAccounts() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Account> accounts = session.createQuery("from Account", Account.class).list();

		for (Account acc : accounts) {
			System.out.println("Account ID: " + acc.getId() + ", Type: " + acc.getAccountType() + ", Balance: " + acc.getBalance());
		}

		session.close();
	}
}