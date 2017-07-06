package com.raysono.codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CaesarCipherTest {

	@Test
	public void encode() {
		String u = "I should have known that you would have a perfect answer for me!!!";
		List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
		assertEquals(v, CaesarCipher.movingShift(u, 1));
	}

	@Test
	public void decode() {
		String u = "I should have known that you would have a perfect answer for me!!!";
		List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
		assertEquals(u, CaesarCipher.demovingShift(v, 1));
	}

	@Test
	public void testShiftUp() {

		assertEquals("shift g + 1", 'h', CaesarCipher.shiftCharUp('g', 1));
		assertEquals("shift G + 1", 'H', CaesarCipher.shiftCharUp('G', 1));

		assertEquals("shift z + 3", 'c', CaesarCipher.shiftCharUp('z', 3));
		assertEquals("shift Z + 3", 'C', CaesarCipher.shiftCharUp('Z', 3));

	}

	@Test
	public void testShiftDown() {

		assertEquals("shift g - 1", 'f', CaesarCipher.shiftCharDown('g', 1));
		assertEquals("shift G - 1", 'F', CaesarCipher.shiftCharDown('G', 1));

		assertEquals("shift a - 3", 'x', CaesarCipher.shiftCharDown('a', 3));
		assertEquals("shift A - 3", 'X', CaesarCipher.shiftCharDown('A', 3));

	}

}