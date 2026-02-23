package in.cg.beans;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private int pId;
	private String pName;
	private String gender;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", gender=" + gender + ", address=" + address + "]";
	}
	
	
}
