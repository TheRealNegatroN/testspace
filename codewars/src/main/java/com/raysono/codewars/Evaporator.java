package com.raysono.codewars;

@SuppressWarnings("WeakerAccess")
public class Evaporator {

	public static int evaporator(double content, double evap_per_day, double threshold) {

		int days = 0;
		final double absThreshold = content * threshold / 100;

		while (content >= (absThreshold)){
			content -= (content * evap_per_day / 100);
			days++;
		}

		return days;
	}
}
