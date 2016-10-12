package com.raysono.codewars;

import java.util.SortedSet;
import java.util.TreeSet;

@SuppressWarnings("WeakerAccess")
public class WhichAreIn {

	public static String[] inArray(String[] array1, String[] array2) {

		SortedSet<String> res = new TreeSet<>();

		for (CharSequence s1 : array1) {
			for (String s2 : array2) {
				if (s2.contains(s1)) {
					res.add(s1.toString());
				}
			}
		}

		return res.toArray(new String[res.size()]);
	}

}
