package in.cg.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}