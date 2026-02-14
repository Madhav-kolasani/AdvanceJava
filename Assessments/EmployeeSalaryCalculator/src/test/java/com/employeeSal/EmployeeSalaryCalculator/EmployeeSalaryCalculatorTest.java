package com.employeeSal.EmployeeSalaryCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeSalaryCalculatorTest {

	@Test
	void testValidSalaryCalculation() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

		calc.validateSalary();

		assertEquals(4000, calc.calculateHRA());
		assertEquals(2000, calc.calculateDA());
		assertEquals(31000, calc.calculateGrossSalary());
		assertEquals(27900, calc.calculateNetSalary());
	}

	@Test
	void testHRA() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(10000, 0, 0);

		assertEquals(2000, calc.calculateHRA());
	}

	@Test
	void testDA() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(10000, 0, 0);

		assertEquals(1000, calc.calculateDA());
	}

	@Test
	void testGrossSalary() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

		assertEquals(31000, calc.calculateGrossSalary());
	}

	@Test
	void testNetSalary() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

		assertEquals(27900, calc.calculateNetSalary());
	}

	// 🔴 Negative Test Cases

	@Test
	void testBasicSalaryZero() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(0, 5000, 10);

		assertThrows(IllegalArgumentException.class, () -> {
		    calc.validateSalary();
		});
	}

	@Test
	void testNegativeSalary() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(-1000, 5000, 10);

		assertThrows(IllegalArgumentException.class, () -> {
		    calc.validateSalary();
		});
	}

	@Test
	void testTaxGreaterThan100() {
		EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 120);

		assertThrows(IllegalArgumentException.class, () -> {
		    calc.validateSalary();
		});
	}
}
