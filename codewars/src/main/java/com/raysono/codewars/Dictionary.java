package com.raysono.codewars;

class Dictionary {

	private final String[] words;

	Dictionary(String[] words) {
		this.words = words;
	}

	String findMostSimilar(String to) {

		int diff = Integer.MAX_VALUE;
		String suggestion = "";

		for (String word : words) {

			// implement levenshtein distance : https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Levenshtein_distance#Java

			int lengthOfWord = word.length() + 1;
			int lengthOfParam = to.length() + 1;

			// the array of distances
			int[] cost = new int[lengthOfWord];
			int[] newcost = new int[lengthOfWord];

			// initial cost of skipping prefix in String s0
			for (int i = 0; i < lengthOfWord; i++) {
				cost[i] = i;
			}

			// dynamically computing the array of distances

			// transformation cost for each letter in s1
			for (int j = 1; j < lengthOfParam; j++) {
				// initial cost of skipping prefix in String s1
				newcost[0] = j;

				// transformation cost for each letter in s0
				for (int i = 1; i < lengthOfWord; i++) {
					// matching current letters in both strings
					int match = (word.charAt(i - 1) == to.charAt(j - 1)) ? 0 : 1;

					// computing cost for each transformation
					int cost_replace = cost[i - 1] + match;
					int cost_insert = cost[i] + 1;
					int cost_delete = newcost[i - 1] + 1;

					// keep minimum cost
					newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
				}

				// swap cost/newcost arrays
				int[] swap = cost;
				cost = newcost;
				newcost = swap;
			}

			// the distance is the cost for transforming all letters in both strings
			int actualDifference = cost[lengthOfWord - 1];

			if (actualDifference < diff) {
				suggestion = word;
				diff = actualDifference;
			}
		}

		return suggestion;
	}
}
