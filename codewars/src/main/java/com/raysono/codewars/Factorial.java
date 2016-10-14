package com.raysono.codewars;

class Factorial {

	int factorial(int n) {

		if (n < 0 || n > 12){
			throw new IllegalArgumentException("only Integers between 0 and 12 are supported");
		}

		int fact = 1;

		if (n != 0) {
			for (int i = 1; i <= n; i++) {
				fact *= i;
			}
		}

		return fact;
	}

}
