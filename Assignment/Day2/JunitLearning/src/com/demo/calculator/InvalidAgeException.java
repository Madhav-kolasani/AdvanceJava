package com.demo.calculator;

public class InvalidAgeException extends RuntimeException{
	public InvalidAgeException(String msg) {
		super(msg);
	}
}
