package in.cg.passenger.controller;


import org.springframework.web.bind.annotation.*;

import in.cg.passenger.dto.PassengerResponse;
import in.cg.passenger.entity.Passenger;
import in.cg.passenger.service.PassengerService;

import java.util.List;

@RestController
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping("/passengerdetails")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.savePassenger(passenger);
    }

    @GetMapping("/passengerdetails")
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/passengerdetails/{id}")
    public PassengerResponse getPassengerWithCar(@PathVariable Long id) {
        return passengerService.getPassengerWithCarDetails(id);
    }
}