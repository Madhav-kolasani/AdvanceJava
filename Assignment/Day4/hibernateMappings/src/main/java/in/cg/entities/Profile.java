package in.cg.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	private String profileName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aadhar")
	private AadharNo aadhar;
	
	
	
	public AadharNo getAadhar() {
		return aadhar;
	}
	public void setAadhar(AadharNo aadhar) {
		this.aadhar = aadhar;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	
}
