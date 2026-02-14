package com.demo.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PalindromeTest {
	Palindrome palindrome = new Palindrome();
	
	@Test
	void isPalindromeTest() {
		String resYes = palindrome.isPalindrome("malayalam");
		assertEquals("It's palindrome", resYes);	
	}
	
	@Test
	void isPalindromeTestForNeg() {
		String resNo = palindrome.isPalindrome("Andra");
		assertEquals("It's not palindrome", resNo);
	}
}
