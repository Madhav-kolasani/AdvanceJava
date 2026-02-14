package com.demo.calculator;

public class Validator{
	
	boolean validateName(String name) {
		return name.length()>8;
	}
	
	boolean validateAge(int age) {
		return age>=18 && age <= 60;
	}
	
	void validate(Employee employee) {
		if(validateAge(employee.getAge())){
			System.out.println("Valid age");
		}else {
			throw new InvalidAgeException("Invalid age");
		}
		
		if(validateName(employee.getName())) {
			System.out.println("Valid Name");
			
		}else {
			throw new InvalidNameException("INvalid name");
		}
		
	}
}
