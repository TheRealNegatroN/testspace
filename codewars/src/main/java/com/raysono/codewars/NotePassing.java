package com.raysono.codewars;

/**
 * Amy and May aren't allowed by their parents to have cell phones, so they still communitcate in class the good old fashioned way, by
 * writing notes.
 * <p>
 * So that no snoopy teachers can read any found notes, the girls communicate in code.
 * <p>
 * May is having a hard time deciphering Amy's latest messages, can you help her figure it out?
 * <p>
 * Input: String written in Amy's code Output: String decoded to Engligh so May can read it
 */
class NotePassing {

	static String decipher(String codedMessage){

		String decrypted = "";

		final int positionsToMove = 7;

		final char[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		final char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		final char[] inputString = codedMessage.toCharArray();
		for (char c : inputString){
			if (Character.isLetter(c)){
				if (Character.isLowerCase(c)){
					c = moveCharacterPosition(c, alphabetLower, positionsToMove);
				} else {
					c = moveCharacterPosition(c, alphabetUpper, positionsToMove);
				}
			}
			decrypted += c;
		}

		return decrypted;
	}

	private static char moveCharacterPosition(char c, final char[] alphabet, final int positionsToMove){
		for (int i = 0; i < alphabet.length; i++) {
			if (c == alphabet[i]) {
				int newPosition = i + positionsToMove;
				if (newPosition >= alphabet.length) {
					newPosition -= alphabet.length;
				}
				c = alphabet[newPosition];
				break;
			}
		}
		return c;
	}
}
