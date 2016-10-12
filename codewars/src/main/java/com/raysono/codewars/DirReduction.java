package com.raysono.codewars;


@SuppressWarnings("WeakerAccess")
public class DirReduction {
	public static String[] dirReduc(String[] arr) {

		final StringBuilder arrayString = new StringBuilder();
		for (String dir : arr){
			arrayString.append(dir).append("#");
		}

		String theString = arrayString.toString();
		while (theString.contains("NORTH#SOUTH#") || theString.contains("SOUTH#NORTH#") || theString.contains("EAST#WEST#") || theString.contains("WEST#EAST#")){
			theString = theString.replace("NORTH#SOUTH#", "");
			theString = theString.replace("SOUTH#NORTH#", "");
			theString = theString.replace("EAST#WEST#", "");
			theString = theString.replace("WEST#EAST#", "");
		}

		if (theString.equals("")){
			return new String[]{};
		} else {
			return theString.split("#");
		}

	}
}
