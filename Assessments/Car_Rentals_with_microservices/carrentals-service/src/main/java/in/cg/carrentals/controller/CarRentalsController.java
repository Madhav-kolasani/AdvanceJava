package in.cg.carrentals.controller;


import org.springframework.web.bind.annotation.*;

import in.cg.carrentals.entity.CarRental;
import in.cg.carrentals.service.CarRentalService;

import java.util.List;

@RestController
public class CarRentalsController {

    private final CarRentalService carRentalService;

    public CarRentalsController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping("/rentalcardetails")
    public CarRental addRentalCar(@RequestBody CarRental carRental) {
        return carRentalService.saveCarRental(carRental);
    }

    @GetMapping("/rentalcardetails")
    public List<CarRental> getAllRentalCars() {
        return carRentalService.getAllCarRentals();
    }

    @GetMapping("/rentalcardetails/{id}")
    public CarRental getRentalCarById(@PathVariable Long id) {
        return carRentalService.getCarRentalById(id);
    }
}