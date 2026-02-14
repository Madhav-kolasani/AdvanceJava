package com.demo.calculator;

public class InvalidNameException extends RuntimeException{
	public InvalidNameException(String msg) {
		super(msg);
	}
}
