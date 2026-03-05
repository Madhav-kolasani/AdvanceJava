package in.cg.main.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public class AddressDto {

	@NotBlank(message = "House number cannot be blank")
	private String houseNo;

	@NotBlank(message = "Street cannot be blank")
	private String street;

	@NotBlank(message = "City cannot be blank")
	@Size(min = 2, max = 50)
	private String city;

	@NotBlank(message = "Pincode cannot be blank")
	@Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits")
	private String pincode;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}