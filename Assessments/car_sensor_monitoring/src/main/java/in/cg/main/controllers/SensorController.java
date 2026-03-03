package in.cg.main.controllers;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.entities.*;
import in.cg.main.services.*;

@RestController
@RequestMapping("/api")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return sensorService.createVehicle(vehicle);
    }

    @PostMapping("/vehicles/{vehicleId}/sensors")
    public String addSensorData(@PathVariable Long vehicleId,
                                @RequestBody SensorReading reading) {
        return sensorService.addSensorData(vehicleId, reading);
    }

    @GetMapping("/vehicles/{vehicleId}/sensors")
    public List<SensorReading> getSensorData(@PathVariable Long vehicleId) {
        return sensorService.getSensorData(vehicleId);
    }
}