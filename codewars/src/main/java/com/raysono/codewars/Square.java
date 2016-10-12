package com.raysono.codewars;

@SuppressWarnings("WeakerAccess")
public class Square {

	public static boolean isSquare(int n) {

		if (n < 0){
			return false;
		} else {
			double div = Math.sqrt(n);
			return  (n % div == 0);
		}
	}
}
