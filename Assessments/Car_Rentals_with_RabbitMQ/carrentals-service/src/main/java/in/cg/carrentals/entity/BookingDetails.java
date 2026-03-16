package in.cg.carrentals.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	private Long passengerId;
	private String passengerName;
	private Long carId;
	private String bookingStatus;

	public BookingDetails() {
	}

	public BookingDetails(Long bookingId, Long passengerId, String passengerName, Long carId, String bookingStatus) {
		this.bookingId = bookingId;
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.carId = carId;
		this.bookingStatus = bookingStatus;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}