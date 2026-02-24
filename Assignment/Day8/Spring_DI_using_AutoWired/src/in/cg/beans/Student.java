package in.cg.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	
	private int id;
	private String name;
	private String email;
	
	@Autowired
	private Address address;


	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student: \nid=" + id + ", \nname=" + name + ", \nemail=" + email + ", \n" + address;
	}
	


}
