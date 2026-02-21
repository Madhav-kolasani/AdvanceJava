package com.crm.services;

import com.crm.entities.Customer;
import com.crm.util.HibernateUtil;
import org.hibernate.*;

public class CustomerService {

    public void registerCustomer(String name, String email, String phone) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
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
        } finally {
            session.close();
        }
    }
}