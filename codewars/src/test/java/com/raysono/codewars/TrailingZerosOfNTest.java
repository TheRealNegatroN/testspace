package com.raysono.codewars;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrailingZerosOfNTest {

	@Test
	public void zeros() throws Exception {
		assertThat(TrailingZerosOfN.zeros(0), is(0));
		assertThat(TrailingZerosOfN.zeros(6), is(1));
		assertThat(TrailingZerosOfN.zeros(14), is(2));
		assertThat(TrailingZerosOfN.zeros(25), is(6));
		assertThat(TrailingZerosOfN.zeros(29), is(6));
		assertThat(TrailingZerosOfN.zeros(30), is(7));
		assertThat(TrailingZerosOfN.zeros(34), is(7));
		assertThat(TrailingZerosOfN.zeros(14), is(2));
		assertThat(TrailingZerosOfN.zeros(100), is(24));
		assertThat(TrailingZerosOfN.zeros(500), is(124));
		assertThat(TrailingZerosOfN.zeros(1000), is(249));
		assertThat(TrailingZerosOfN.zeros(10000), is(2499));
	}

}