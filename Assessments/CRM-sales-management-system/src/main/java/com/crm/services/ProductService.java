package com.crm.services;

import com.crm.entities.Product;
import com.crm.util.HibernateUtil;
import org.hibernate.*;

public class ProductService {

    public void addProduct(String name, double price) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Product product = new Product();
            product.setProductName(name);
            product.setPrice(price);

            session.persist(product);

            tx.commit();
            System.out.println("Product Added Successfully!");

        } catch (Exception e) {
            if (tx != null) {
				tx.rollback();
			}
        } finally {
            session.close();
        }
    }
}