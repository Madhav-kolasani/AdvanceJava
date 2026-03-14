package in.cg.carrentals.service;


import org.springframework.stereotype.Service;

import in.cg.carrentals.entity.CarRental;
import in.cg.carrentals.repository.CarRentalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;

    public CarRentalService(CarRentalRepository carRentalRepository) {
        this.carRentalRepository = carRentalRepository;
    }

    public CarRental saveCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }

    public List<CarRental> getAllCarRentals() {
        return carRentalRepository.findAll();
    }

    public CarRental getCarRentalById(Long id) {
        Optional<CarRental> optional = carRentalRepository.findById(id);
        return optional.orElse(null);
    }
}