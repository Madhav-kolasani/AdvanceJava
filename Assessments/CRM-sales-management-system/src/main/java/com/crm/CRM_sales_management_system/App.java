package com.crm.CRM_sales_management_system;

import com.crm.services.*;
import com.crm.util.HibernateUtil;

import java.util.*;

public class App {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CustomerService customerService = new CustomerService();
		ProductService productService = new ProductService();
		OrderService orderService = new OrderService();

		while (true) {
			System.out.println("1. Register Customer");
			System.out.println("2. Add Product");
			System.out.println("3. Place Order");
			System.out.println("4. Exit");

			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Email: ");
				String email = sc.next();
				System.out.print("Phone: ");
				String phone = sc.next();
				customerService.registerCustomer(name, email, phone);
				break;

			case 2:
				System.out.print("Product Name: ");
				String pname = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				productService.addProduct(pname, price);
				break;

			case 3:
				System.out.print("Customer ID: ");
				Long cid = sc.nextLong();
				System.out.print("Enter Product IDs (comma separated): ");
				sc.nextLine();
				String input = sc.nextLine();

				List<Long> productIds = new ArrayList<>();
				for (String s : input.split(",")) {
					productIds.add(Long.parseLong(s.trim()));
				}
				orderService.placeOrder(cid, productIds);
				break;

			case 4:
				HibernateUtil.getSessionFactory().close();
				System.exit(0);
			}
		}
	}
}