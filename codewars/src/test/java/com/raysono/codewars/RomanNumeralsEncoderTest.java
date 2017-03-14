package com.raysono.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsEncoderTest {

	private RomanNumeralsEncoder conversion = new RomanNumeralsEncoder();

	@Test
	public void testConvertOneDigit() {
		assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
		assertEquals("solution(3) should equal to III", "III", conversion.solution(3));
		assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
		assertEquals("solution(5) should equal to V", "V", conversion.solution(5));
		assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
		assertEquals("solution(8) should equal to VIII", "VIII", conversion.solution(8));
		assertEquals("solution(9) should equal to IX", "IX", conversion.solution(9));
	}

	@Test
	public void testConvertTwoDigits() {
		assertEquals("solution(10) should equal to X", "X", conversion.solution(10));
		assertEquals("solution(11) should equal to XI", "XI", conversion.solution(11));
		assertEquals("solution(14) should equal to XIV", "XIV", conversion.solution(14));
		assertEquals("solution(19) should equal to XIX", "XIX", conversion.solution(19));
		assertEquals("solution(20) should equal to XX", "XX", conversion.solution(20));
		assertEquals("solution(28) should equal to XXVIII", "XXVIII", conversion.solution(28));
		assertEquals("solution(40) should equal to XL", "XL", conversion.solution(40));
		assertEquals("solution(40) should equal to XL", "XL", conversion.solution(40));
		assertEquals("solution(44) should equal to XLIV", "XLIV", conversion.solution(44));
		assertEquals("solution(49) should equal to XLIX", "XLIX", conversion.solution(49));
		assertEquals("solution(50) should equal to L", "L", conversion.solution(50));
		assertEquals("solution(68) should equal to LXVIII", "LXVIII", conversion.solution(68));
		assertEquals("solution(89) should equal to LXXXIX", "LXXXIX", conversion.solution(89));
		assertEquals("solution(94) should equal to XCIV", "XCIV", conversion.solution(94));
		assertEquals("solution(99) should equal to XCIX", "XCIX", conversion.solution(99));
	}

	@Test
	public void testConvertThreeDigits() {
		assertEquals("solution(100) should equal to C", "C", conversion.solution(100));
		assertEquals("solution(109) should equal to CIX", "CIX", conversion.solution(109));
		assertEquals("solution(128) should equal to CXXVIII", "CXXVIII", conversion.solution(128));
		assertEquals("solution(145) should equal to CXLV", "CXLV", conversion.solution(145));
		assertEquals("solution(452) should equal to CDLII", "CDLII", conversion.solution(452));
		assertEquals("solution(543) should equal to DXLIII", "DXLIII", conversion.solution(543));
		assertEquals("solution(984) should equal to CMLXXXIV", "CMLXXXIV", conversion.solution(984));
	}

	@Test
	public void testConvertFourDigits(){
		assertEquals("solution(1904) should equal to MCMIV", "MCMIV", conversion.solution(1904));
		assertEquals("solution(1954) should equal to MCMLIV", "MCMLIV", conversion.solution(1954));
		assertEquals("solution(1990) should equal to MCMXC", "MCMXC", conversion.solution(1990));
		assertEquals("solution(2014) should equal to MMXIV", "MMXIV", conversion.solution(2014));
	}
}