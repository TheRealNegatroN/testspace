package com.raysono.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class HighestAndLowestTest {

	@Test
	public void Test1() {
		assertEquals("5 1", HighestAndLowest.HighAndLow("1 2 3 4 5"));
	}

	@Test
	public void Test2() {
		assertEquals("5 -3", HighestAndLowest.HighAndLow("1 2 -3 4 5"));
	}

	@Test
	public void Test3() {
		assertEquals("9 -5", HighestAndLowest.HighAndLow("1 9 3 4 -5"));
	}

	@Test
	public void Test4() {
		assertEquals("42 -9", HighestAndLowest.HighAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
	}

}