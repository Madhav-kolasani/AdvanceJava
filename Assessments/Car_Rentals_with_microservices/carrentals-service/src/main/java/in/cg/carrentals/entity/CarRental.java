package in.cg.carrentals.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car_rentals")
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    private String carName;
    private String carType;
    private Double pricePerDay;
    private String availability;

    public CarRental() {
    }

    public CarRental(Long carId, String carName, String carType, Double pricePerDay, String availability) {
        this.carId = carId;
        this.carName = carName;
        this.carType = carType;
        this.pricePerDay = pricePerDay;
        this.availability = availability;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}