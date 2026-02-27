package in.cg.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.entities.Customer;
import in.cg.util.HibernateUtil;

public class CustomerService {

	public void registerCustomer(String name, String email, String phone) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Customer customer = new Customer();
			customer.setName(name);
			customer.setEmail(email);
			customer.setPhone(phone);

			session.persist(customer);

			tx.commit();

			System.out.println("Customer Registered Successfully!");

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}
}
