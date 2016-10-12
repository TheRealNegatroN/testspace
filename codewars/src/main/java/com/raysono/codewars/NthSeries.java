package com.raysono.codewars;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@SuppressWarnings("WeakerAccess")
public class NthSeries {

	public static String seriesSum(int n) {

		String retval;
		int divider = 1;
		double x = 0;

		for (int i = 0; i < n; i++) {
			x = x + (1.0 / divider);
			divider += 3;
		}

		NumberFormat format = DecimalFormat.getInstance(Locale.ENGLISH);
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);

		retval = format.format(x);

		return retval;

	}



}
