package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_details")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private String customerName;

    private String roomType;

    private String checkInDate;
    private String checkOutDate;

    // Stores price per day based on roomType
    private double totalAmount;

    public Booking() {
    }

    // Optional constructor
    public Booking(String customerName, String roomType,
                   String checkInDate, String checkOutDate) {
        this.customerName = customerName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        setRoomPrice();
    }

    private void setRoomPrice() {

        int pricePerDay;

        switch (roomType.toLowerCase()) {
            case "standard":
                pricePerDay = 2000;
                break;
            case "deluxe":
                pricePerDay = 3500;
                break;
            case "suite":
                pricePerDay = 5000;
                break;
            default:
                throw new IllegalArgumentException("Invalid room type");
        }

        this.totalAmount = pricePerDay;
    }

    // Getters & Setters

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
        setRoomPrice();   // auto price assignment
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
