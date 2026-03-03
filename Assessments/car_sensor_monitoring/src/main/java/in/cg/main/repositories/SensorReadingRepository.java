package in.cg.main.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entities.SensorReading;

import java.util.List;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    List<SensorReading> findByVehicleId(Long vehicleId);
}
