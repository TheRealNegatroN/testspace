package com.raysono.codewars;

class RomanNumeralsEncoder {

	private static final String[] unus = {"I", "IV", "V", "IX"};
	private static final String[] decem = {"X", "XL", "L", "XC"};
	private static final String[] centum = {"C", "CD", "D", "CM"};
	private static final String mille = "M";

	String solution(int n) {

		final StringBuilder roman = new StringBuilder();
		final char[] numberAsChars = String.valueOf(n).toCharArray();

		final int length = numberAsChars.length;

		if (length > 3){
			final int posMille = Character.getNumericValue(numberAsChars[length - 4]);
			for (int i = 1; i <= posMille; i++){
				roman.append(mille);
			}
		}

		if (length > 2) {
			final int posCentum = Character.getNumericValue(numberAsChars[length - 3]);
			roman.append(convert(posCentum, centum));
		}

		if (length > 1) {
			final int posDecem = Character.getNumericValue(numberAsChars[length - 2]);
			roman.append(convert(posDecem, decem));
		}

		final int posUnus = Character.getNumericValue(numberAsChars[length - 1]);
		roman.append(convert(posUnus, unus));

		return roman.toString();
	}

	private String convert(final int digit, final String[] romanLetters){

		final StringBuilder roman = new StringBuilder();

		if (digit != 0) {
			if (digit < 4) {
				for (int i = 1; i <= digit; i++) {
					roman.append(romanLetters[0]);
				}
			} else if (digit < 9) {
				if (digit == 4) {
					roman.append(romanLetters[1]);
				} else {
					roman.append(romanLetters[2]);
					for (int i = 6; i <= digit; i++) {
						roman.append(romanLetters[0]);
					}
				}
			} else {
				roman.append(romanLetters[3]);
			}
		}

		return roman.toString();
	}

}
