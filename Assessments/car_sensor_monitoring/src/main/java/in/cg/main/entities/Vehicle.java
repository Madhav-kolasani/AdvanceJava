package in.cg.main.entities;

import jakarta.persistence.*;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String vehicleNumber;
	private String ownerName;

	public Vehicle() {
	}

	public Vehicle(String vehicleNumber, String ownerName) {
		this.vehicleNumber = vehicleNumber;
		this.ownerName = ownerName;
	}

	public Long getId() {
		return id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
