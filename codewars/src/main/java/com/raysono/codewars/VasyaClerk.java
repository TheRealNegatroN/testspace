package com.raysono.codewars;

@SuppressWarnings("WeakerAccess")
public class VasyaClerk {

	public static String Tickets(int[] peopleInLine)
	{
		String res = "YES";

		int bills25 = 0;
		int bills50 = 0;

		outerloop:
		for (int bill : peopleInLine){

			switch (bill){
				case 25:
					bills25++;
					break;
				case 50:
					bills50++;
					if (bills25 > 0){
						bills25--;
					} else {
						res = "NO";
						break outerloop;
					}
					break;
				case 100:
					if (bills50 > 0 && bills25 > 0){
						bills25--;
						bills50--;
					} else if (bills25 > 2) {
						bills25 -= 3;
					} else {
						res = "NO";
						break outerloop;
					}
					break;
				default:
					// do nothing
			}

		}

		return res;
	}
}
