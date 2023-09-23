package com.promineotech;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	
	public int addPositive (int a, int b) {
		if(a > 0 && b > 0) {
			return a+b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive.");
		}
	}
	//setting up a method to multiply two integers so long as the product of the two is less than 500. Illegal argument Exception is thrown if the product is over 500
	
	public int multiplyWithLimit (int a, int b) {
		int multiply = a*b;
		if (multiply >= 500) {
			throw new IllegalArgumentException("Over the limit!");
		} else {
			return multiply;
		}
	}
	
	//Mocking a class 
	@VisibleForTesting
	public int randomNumberSquared () {
		int number = getRandomInt();
		int squaredNumber = (int) Math.pow(number, 2);
		return squaredNumber;
		
	}
	
	@VisibleForTesting 
	int getRandomInt() {
		Random rNum = new Random();
		int randomNumber = rNum.nextInt(10) + 1;
		return randomNumber;
		
	}

}
