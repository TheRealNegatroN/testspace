package com.raysono.codewars;

class MorseCodeDecoder {

	private static final String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " ", ".", ",", "?", "!", "SOS"};
	private static final String[] dots = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
			"-" + ".", "---", ".--" + ".", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---",
			"...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "   ", ".-.-.-", "--..--", "..--..", "-.-.--",
			"...---..."};

	static String decode(String morseCode) {

		if (morseCode.contains(".") || morseCode.contains("-")) {
			morseCode = morseCode.trim();
		}

		// split into words
		String[] words = morseCode.split("[\\s]{3}");

		final StringBuilder result = new StringBuilder();

		for (final String word : words) {
			result.append(decodeWord(word));
			result.append(" ");
		}

		return result.toString().trim();
	}

	private static String decodeWord(final String word) {

		final String[] letters = word.split(" ");

		final StringBuilder result = new StringBuilder();

		for (final String letter : letters) {
			for (int i = 0; i < dots.length; i++) {
				if (dots[i].equals(letter)) {
					result.append(alpha[i]);
					break;
				}
			}
		}

		return result.toString();
	}
}
