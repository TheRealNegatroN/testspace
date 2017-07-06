package com.raysono.codewars;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("SameParameterValue")
class CaesarCipher {

	static List<String> movingShift(final String input, int shift) {

		final String[] parts = splitIntoFiveParts(input);

		for (int i = 0; i < parts.length; i++) {
			char[] chars = parts[i].toCharArray();
			StringBuilder temp = new StringBuilder();
			for (char c : chars) {
				if (Character.isLetter(c)) {
					temp.append(shiftCharUp(c, shift));
				} else {
					temp.append(c);
				}

				if (shift == 26) {
					shift = 1;
				} else {
					shift++;
				}
			}
			parts[i] = temp.toString();
		}

		return Arrays.asList(parts);
	}

	private static String[] splitIntoFiveParts(final String input) {
		int div = input.length() / 5;
		if (input.length() % 5 != 0) {
			div++;
		}
		final String[] inputAsArray = input.split("(?<=\\G.{" + div + "})");
		final String[] returnArrayWithSizeFive = {"", "", "", "", ""};

		System.arraycopy(inputAsArray, 0, returnArrayWithSizeFive, 0, inputAsArray.length);
		return returnArrayWithSizeFive;
	}

	static String demovingShift(List<String> stringList, int shift) {

		StringBuilder partsAsString = new StringBuilder();
		for (String part : stringList) {
			partsAsString.append(part);
		}

		char[] encodedStringAsChars = partsAsString.toString().toCharArray();

		StringBuilder temp = new StringBuilder();

		for (char c : encodedStringAsChars) {
			if (Character.isLetter(c)) {
				temp.append(shiftCharDown(c, shift));
			} else {
				temp.append(c);
			}

			if (shift == 26) {
				shift = 1;
			} else {
				shift++;
			}
		}

		return temp.toString();
	}

	static char shiftCharUp(char c, int shift){

		int shifted = c + shift;
		if ((c > 97 && shifted > 122) || (c <= 90 && shifted > 90)) {
			shifted -= 26;
		}

		return (char) shifted;

	}

	static char shiftCharDown(char c, int shift){

		int shifted = c - shift;
		if ((c <= 90 && shifted < 65) || (c >= 97 && shifted < 97)) {
			shifted += 26;
		}

		return (char) shifted;

	}
}
