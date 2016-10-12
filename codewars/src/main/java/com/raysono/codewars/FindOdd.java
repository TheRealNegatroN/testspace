package com.raysono.codewars;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class FindOdd {

	public static int findIt(int[] A) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : A) {
			int count = 1;
			if (map.containsKey(i)) {
				count = map.get(i);
				count++;
			}
			map.put(i, count);
		}

		int odd = -1;

		for (int i : map.keySet()) {
			if (map.get(i) % 2 != 0) {
				odd = i;
			}
		}

		return odd;
	}
}
