package in.cg.beans;

public class Student {
	
	private int id;
	private String name;
	private String email;
	
	private Address address;


	public Student(int id, String name, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}



	@Override
	public String toString() {
		return "Student: \nid=" + id + ", \nname=" + name + ", \nemail=" + email + ", \n" + address;
	}
	


}
