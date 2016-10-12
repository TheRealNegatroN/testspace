package com.raysono.codewars;

@SuppressWarnings("WeakerAccess")
public class TrailingZerosOfN {

	public static int zeros(int n) {

		int sum = 0;

		for (int i = 5; i <= n; i *= 5) {
			sum += n / i;
		}

		return sum;
	}
}
