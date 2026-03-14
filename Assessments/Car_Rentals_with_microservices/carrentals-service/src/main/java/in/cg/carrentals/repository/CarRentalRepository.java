package in.cg.carrentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.carrentals.entity.CarRental;

public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
}