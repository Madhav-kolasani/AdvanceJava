package com.demo.calculator;

public class Calculator {
	int add(int a, int b) {
		return a + b;
	}

	int sub(int a, int b) {
		return a - b;
	}

	int mul(int a, int b) {
		return a * b;
	}

	int div(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Cannot divid by zero");
		}
		return a / b;
	}
	
	boolean even(int a) {
		return (a&1)==0;
	}
}
