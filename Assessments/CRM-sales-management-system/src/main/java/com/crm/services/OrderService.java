package com.crm.services;

import com.crm.entities.*;
import com.crm.util.HibernateUtil;
import org.hibernate.*;

import java.util.List;

public class OrderService {

	public void placeOrder(Long customerId, List<Long> productIds) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Customer customer = session.get(Customer.class, customerId);

			if (customer == null) {
				System.out.println("Customer not found!");
				return;
			}

			CustomerOrder order = new CustomerOrder();

			order.setOrderDate("2026-02-21");
			order.setCustomer(customer);

			double total = 0;

			for (Long id : productIds) {
				Product product = session.get(Product.class, id);

				if (product != null) {
					order.getProducts().add(product);
					total += product.getPrice();
				}
			}

			order.setTotalAmount(total);

			session.persist(order);

			tx.commit();
			System.out.println("Order Placed Successfully!");

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}