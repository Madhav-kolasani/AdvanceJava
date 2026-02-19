package in.cg.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhaar_id", nullable = false, unique = true)
    private AadharNo aadhaar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AadharNo getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(AadharNo aadhaar) {
		this.aadhaar = aadhaar;
	}
	
}
