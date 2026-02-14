package com.demo.calculator;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	Calculator calculator = new Calculator();

//	@Test
//	void testAdd() {
//		int result = calculator.add(2, 3);
//		assertEquals(5, result);
//	}

	@Test
	void testAdd() {
		int result = calculator.add(2, 3);
		assertTrue(result == 5);
	}
	
	@ParameterizedTest  // this is csv sourse 
	@CsvSource({
		"1, 2,3",
		"8, 8, 16",
		"6, 9, 15"
	})
	void testAddition(int a, int b, int expected) {
		assertEquals(expected, calculator.add(a, b));
	}
	
	@ParameterizedTest
	@ValueSource(ints= {2,4,8,20})  // we used value source annotation here
	void testIsEven(int a) {
		assertTrue(calculator.even(a));
	}
	
	// Now csv file source
	
	@ParameterizedTest
	@CsvFileSource(resources="testData.csv", numLinesToSkip=0)
	void testAdditionWithFile(int a, int b, int excepted) {
		assertEquals(excepted, calculator.add(a, b));
	}
	
	
	@Test
	void testSub() {
		int result = calculator.sub(10, 5);
		assertEquals(5, result);
	}

	@Test
	void testMul() {
		int result = calculator.mul(10, 5);
		assertEquals(50, result);
		
	}

	@Test
	void testDiv() {
		int result = calculator.div(10, 5);
		assertEquals(2, result);
	}

	@Test
	void shouldThrowExceptionWhenDividingByZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.div(10, 0);
		});
	}
}
