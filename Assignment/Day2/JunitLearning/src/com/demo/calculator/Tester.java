package com.demo.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Tester {
	
	Validator validator = new Validator();
	
	@Test
	void validateNameValidTest1() {
		boolean res = validator.validateName("Sam Johns");
		assertEquals(true, res);
	}
	
	@Test
	void validateNameInvalidTest1() {
		boolean res = validator.validateName("Jonathan");
		assertEquals(false, res);
	}
	
	@Test
	void validateAgeValidTest1() {
		boolean res = validator.validateAge(18);
		assertEquals(true, res);
	}
	
	@Test
	void validateAgeInvalidTest1() {
		boolean res = validator.validateAge(17);
		assertEquals(false, res);
	}
	
	@Test
	void validateInvalidNameTest() {
		Employee e = new Employee("Maria Francis",2000,25);
		validator.validate(e);
		
	}
	
	
}
