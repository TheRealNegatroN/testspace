package com.raysono.codewars;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Dinglemouse {

	private static final String[] tensNames = {"", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " " +
			"ninety"};

	private static final String[] numNames = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
			" eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};

	static int[] sort(final int array[]) {

		final List<Number> numbers = new LinkedList<>();
		for (int num : array) {
			numbers.add(new Number(num, convert(num)));
		}

		Collections.sort(numbers);

		final int[] sorted = new int[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			sorted[i] = numbers.get(i).getIntval();
		}

		return sorted;
	}

	private static String convert(int number) {

		if (number == 0) {
			return "zero";
		}

		String numberAsString;

		if (number % 100 < 20) {
			numberAsString = numNames[number % 100];
			number /= 100;
		} else {
			numberAsString = numNames[number % 10];
			number /= 10;

			numberAsString = tensNames[number % 10] + numberAsString;
			number /= 10;
		}
		if (number == 0) {
			return numberAsString;
		}

		return numNames[number] + " hundred" + numberAsString;

	}

	static class Number implements Comparable<Number> {
		private final int intval;
		private final String name;

		Number(final int intval, final String name) {
			this.intval = intval;
			this.name = name;
		}

		int getIntval() {
			return intval;
		}

		String getName() {
			return name;
		}

		@Override
		public int compareTo(Number o) {
			return name.compareTo(o.getName());
		}
	}
}
