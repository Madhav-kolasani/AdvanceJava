package in.cg.carrentals.service;


import org.springframework.stereotype.Service;

import in.cg.carrentals.entity.BookingDetails;
import in.cg.carrentals.repository.BookingDetailsRepository;

import java.util.List;

@Service
public class BookingDetailsService {

    private final BookingDetailsRepository bookingDetailsRepository;

    public BookingDetailsService(BookingDetailsRepository bookingDetailsRepository) {
        this.bookingDetailsRepository = bookingDetailsRepository;
    }

    public BookingDetails saveBooking(BookingDetails bookingDetails) {
        return bookingDetailsRepository.save(bookingDetails);
    }

    public List<BookingDetails> getAllBookings() {
        return bookingDetailsRepository.findAll();
    }
}