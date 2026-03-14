package in.cg.passenger.service;


import org.springframework.stereotype.Service;

import in.cg.passenger.dto.PassengerResponse;
import in.cg.passenger.dto.RentalCarDetails;
import in.cg.passenger.entity.Passenger;
import in.cg.passenger.feign.CarRentalsFeignClient;
import in.cg.passenger.repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final CarRentalsFeignClient carRentalsFeignClient;

    public PassengerService(PassengerRepository passengerRepository,
                            CarRentalsFeignClient carRentalsFeignClient) {
        this.passengerRepository = passengerRepository;
        this.carRentalsFeignClient = carRentalsFeignClient;
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public PassengerResponse getPassengerWithCarDetails(Long passengerId) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerId);

        if (optionalPassenger.isEmpty()) {
            return null;
        }

        Passenger passenger = optionalPassenger.get();
        List<RentalCarDetails> cars = carRentalsFeignClient.getAllRentalCars();

        RentalCarDetails matchedCar = null;

        for (RentalCarDetails car : cars) {
            if (car.getCarId().equals(passenger.getCarId())) {
                matchedCar = car;
                break;
            }
        }

        return new PassengerResponse(passenger, matchedCar);
    }
}