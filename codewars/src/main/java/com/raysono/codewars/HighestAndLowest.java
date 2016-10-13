package com.raysono.codewars;

class HighestAndLowest {

	static String HighAndLow(String numbers) {

		String[] numbersAsArray =  numbers.split(" ");

		int highest = Integer.MIN_VALUE;
		int lowest = Integer.MAX_VALUE;
		for (String number : numbersAsArray){
			int i = Integer.parseInt(number);
			if (i > highest){
				highest = i;
			}
			if (i < lowest){
				lowest = i;
			}
		}

		return highest + " " + lowest;
	}

}
