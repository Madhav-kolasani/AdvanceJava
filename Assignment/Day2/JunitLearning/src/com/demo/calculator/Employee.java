package com.demo.calculator;

public class Employee {
	String name;
	double monthlySalary;
	int age;
	
	
	
	public Employee(String name, double monthlySalary, int age) {
		super();
		this.name = name;
		this.monthlySalary = monthlySalary;
		this.age = age;
	}

	public double calculateAnnualSalary() {
		
		if(age>=18 && age <= 50) {
			this.monthlySalary = this.monthlySalary*0.6;
		}else if(age>50 && age <= 60) {
			this.monthlySalary = this.monthlySalary*0.7;			
		}
		return monthlySalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
