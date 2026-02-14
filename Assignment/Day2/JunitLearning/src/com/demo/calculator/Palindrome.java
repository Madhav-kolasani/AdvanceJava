package com.demo.calculator;

public class Palindrome {
	public String isPalindrome(String palin) {
		return (new StringBuilder(palin).reverse().toString().equals(palin)==true)?"It's palindrome": "It's not palindrome"; 
	}
}

