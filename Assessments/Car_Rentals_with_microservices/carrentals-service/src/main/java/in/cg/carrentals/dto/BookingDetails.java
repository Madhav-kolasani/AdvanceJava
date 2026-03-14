package in.cg.carrentals.dto;

public class BookingDetails {
    private Long bookingId;
    private String passengerName;
    private String carName;
    private String bookingStatus;

    public BookingDetails() {
    }

    public BookingDetails(Long bookingId, String passengerName, String carName, String bookingStatus) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.carName = carName;
        this.bookingStatus = bookingStatus;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}