package in.cg.entities;

import java.util.List;

public class Bank {
	private int id;
	private String name;
	
	private List<Customer> c;

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

	public List<Customer> getC() {
		return c;
	}

	public void setC(List<Customer> c) {
		this.c = c;
	}
}
