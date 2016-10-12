package com.raysono.codewars;

@SuppressWarnings("WeakerAccess")
public class PlayPass {

	public static String playPass(String s, int n) {

		final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		final char[] inputString = s.toUpperCase().toCharArray();

		final StringBuilder retval = new StringBuilder();

		for (int y = 0; y < inputString.length; y++) {
			final char charToMove = inputString[y];
			if (Character.isDigit(charToMove)) {
				retval.append(9 - Character.getNumericValue(charToMove));
			} else if (Character.isLetter(charToMove)) {
				for (int i = 0; i < alphabet.length; i++) {
					if (charToMove == alphabet[i]) {

						int newPosition = i + n;
						if (newPosition >= alphabet.length) {
							newPosition -= alphabet.length;
						}

						if (y % 2 != 0){
							retval.append(Character.toLowerCase(alphabet[newPosition]));
						} else {
							retval.append(alphabet[newPosition]);
						}
					}
				}
			} else {
				retval.append(charToMove);
			}
		}

		return retval.reverse().toString();
	}
}

