package in.cg.carrentals.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import in.cg.carrentals.config.RabbitMqConfig;
import in.cg.carrentals.dto.PassengerCreatedEvent;
import in.cg.carrentals.entity.BookingDetails;

@Service
public class PassengerEventListener {

    private final BookingDetailsService bookingDetailsService;

    public PassengerEventListener(BookingDetailsService bookingDetailsService) {
        this.bookingDetailsService = bookingDetailsService;
    }

    @RabbitListener(
            queues = RabbitMqConfig.QUEUE,
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void consumePassengerCreatedEvent(PassengerCreatedEvent event) {
        System.out.println("Passenger event received for passengerId: " + event.getPassengerId());

        BookingDetails booking = new BookingDetails();
        booking.setPassengerId(event.getPassengerId());
        booking.setPassengerName(event.getPassengerName());
        booking.setCarId(event.getCarId());
        booking.setBookingStatus("BOOKING_CREATED");

        bookingDetailsService.saveBooking(booking);

        System.out.println("Booking saved for passengerId: " + event.getPassengerId());
    }
}