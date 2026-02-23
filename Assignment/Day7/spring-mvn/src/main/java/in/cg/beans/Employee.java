package in.cg.beans;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int EId;
	private String EName;
	private double Salary;
	public int getEId() {
		return EId;
	}
	public void setEId(int eId) {
		EId = eId;
	}
	public String getEName() {
		return EName;
	}
	public void setEName(String eName) {
		EName = eName;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [EId=" + EId + ", EName=" + EName + ", Salary=" + Salary + "]";
	}
	
	
}
