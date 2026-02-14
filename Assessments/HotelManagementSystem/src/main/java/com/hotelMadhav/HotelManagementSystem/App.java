package com.hotelMadhav.HotelManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Booking;

import java.util.List;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {

            // CREATE
            tx = session.beginTransaction();

            Booking booking = new Booking("Madhav","Deluxe","2026-02-15","2026-02-18");
            Booking booking1 = new Booking("Raju","Standard","2024-06-5","2024-06-6");
            Booking booking2 = new Booking("Lakshman","Suite","2026-02-13","2024-02-14");


            session.persist(booking);
            session.persist(booking1);
            session.persist(booking2);
            tx.commit();

            System.out.println("Booking Inserted: " + booking.getBookingId());

            // READ ALL
            List<Booking> bookings = session.createQuery("from Booking", Booking.class).list();

            System.out.println("All Bookings:");
            bookings.forEach(b -> System.out.println(b.getBookingId() + " | " +b.getCustomerName() + " | " +b.getRoomType() + " | " +  b.getTotalAmount()));

            // UPDATE
            tx = session.beginTransaction();
            Booking b = session.get(Booking.class, booking.getBookingId());
            b.setRoomType("Suite");
            tx.commit();

            System.out.println("Booking Updated");

            // DELETE
            tx = session.beginTransaction();
            session.remove(b);
            tx.commit();

            System.out.println("Booking Deleted");

        } catch (Exception e) {
            if (tx != null) {
				tx.rollback();
			}
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

        System.out.println("CRUD Completed");
    }
}
