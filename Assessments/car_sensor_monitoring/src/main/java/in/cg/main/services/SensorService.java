package in.cg.main.services;


import org.springframework.stereotype.Service;

import in.cg.main.entities.*;
import in.cg.main.repositories.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorService {

    private final VehicleRepository vehicleRepository;
    private final SensorReadingRepository sensorReadingRepository;

    public SensorService(VehicleRepository vehicleRepository,
                         SensorReadingRepository sensorReadingRepository) {
        this.vehicleRepository = vehicleRepository;
        this.sensorReadingRepository = sensorReadingRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public String addSensorData(Long vehicleId, SensorReading reading) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        reading.setVehicle(vehicle);
        reading.setTimestamp(LocalDateTime.now());

        sensorReadingRepository.save(reading);

        checkAlerts(reading);

        return "Sensor data saved successfully";
    }

    public List<SensorReading> getSensorData(Long vehicleId) {
        return sensorReadingRepository.findByVehicleId(vehicleId);
    }

    private void checkAlerts(SensorReading reading) {

        if (reading.getEngineTemperature() > 110) {
            System.out.println("ALERT: High Engine Temperature!");
        }

        if (reading.getFuelLevel() < 10) {
            System.out.println("ALERT: Low Fuel Level!");
        }

        if (reading.getTirePressure() < 25) {
            System.out.println("ALERT: Low Tire Pressure!");
        }
    }
}
