package com.raysono.codewars;

class StripComments {

	static String stripComments(String text, String[] commentSymbols) {

		final String[] parts = text.split("\\n");

		final StringBuilder result = new StringBuilder();
		for (String part : parts) {
			for (final String commentSymbol : commentSymbols) {
				if (part.contains(commentSymbol)) {
					part = part.substring(0, part.indexOf(commentSymbol));
				}
			}
			if (result.length() > 0) {
				result.append("\n");
			}
			final String partTrimmedRight = part.replaceAll("\\s+$", "");
			result.append(partTrimmedRight);
		}

		return result.toString();
	}
}
