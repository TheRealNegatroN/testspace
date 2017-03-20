package com.raysono.codewars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WeightSort {

	static String orderWeight(String strng) {

		if (strng.isEmpty()){
			return strng;
		}

		final String[] weightsToSort = strng.split("\\s+");

		final List<OrderedWeight> orderedWeights = new ArrayList<>();
		for (final String weight : weightsToSort){
			orderedWeights.add(new OrderedWeight(new BigInteger(weight)));
		}

		Collections.sort(orderedWeights);

		String output = "";
		for (final OrderedWeight orderedWeight : orderedWeights){
			output += orderedWeight.getWeight();
			output += " ";
		}

		return output.trim();
	}

	public static class OrderedWeight implements Comparable<OrderedWeight> {

		private BigInteger weight;

		OrderedWeight(BigInteger weight) {
			this.weight = weight;
		}

		BigInteger getWeight() {
			return weight;
		}

		private int getSumOfDigits(){
			final String weightAsString = String.valueOf(this.getWeight());
			final String[] digits = weightAsString.split("(?<=.)");
			int sum = 0;
			for (final String i : digits){
				sum += Integer.parseInt(i);
			}
			return sum;
		}

		@Override
		public int compareTo(OrderedWeight o) {

			final int sum1 = getSumOfDigits();
			final int sum2 = o.getSumOfDigits();

			if (sum1 > sum2){
				return 1;
			} else if (sum1 < sum2){
				return -1;
			} else {
				return String.valueOf(getWeight()).compareTo(String.valueOf(o.getWeight()));
			}
		}
	}
}
