package com.raysono.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeightSortTest {

	@Test
	public void orderWeight() throws Exception {
		final String input =  "59544965313";
		final String expected = "59544965313";
		final String actual = WeightSort.orderWeight(input);
		assertEquals(expected, actual);
	}

	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
		assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
	}

}