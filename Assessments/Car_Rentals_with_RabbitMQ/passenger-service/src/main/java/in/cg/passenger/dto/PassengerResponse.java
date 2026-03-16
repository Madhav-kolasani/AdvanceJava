package in.cg.passenger.dto;

import in.cg.passenger.entity.Passenger;

public class PassengerResponse {

    private Passenger passenger;
    private RentalCarDetails rentalCarDetails;

    public PassengerResponse() {
    }

    public PassengerResponse(Passenger passenger, RentalCarDetails rentalCarDetails) {
        this.passenger = passenger;
        this.rentalCarDetails = rentalCarDetails;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public RentalCarDetails getRentalCarDetails() {
        return rentalCarDetails;
    }

    public void setRentalCarDetails(RentalCarDetails rentalCarDetails) {
        this.rentalCarDetails = rentalCarDetails;
    }
}