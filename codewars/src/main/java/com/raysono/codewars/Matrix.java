package com.raysono.codewars;

class Matrix {

	static void enter() {
		throwException(new Neo());
	}

	private static <T extends Throwable> void throwException(Throwable exception) throws T {
		throw (T) exception;
	}
}
