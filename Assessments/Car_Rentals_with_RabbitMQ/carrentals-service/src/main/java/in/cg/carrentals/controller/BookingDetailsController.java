package in.cg.carrentals.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cg.carrentals.entity.BookingDetails;
import in.cg.carrentals.service.BookingDetailsService;

import java.util.List;

@RestController
public class BookingDetailsController {

    private final BookingDetailsService bookingDetailsService;

    public BookingDetailsController(BookingDetailsService bookingDetailsService) {
        this.bookingDetailsService = bookingDetailsService;
    }

    @GetMapping("/bookingdetails")
    public List<BookingDetails> getAllBookings() {
        return bookingDetailsService.getAllBookings();
    }
}