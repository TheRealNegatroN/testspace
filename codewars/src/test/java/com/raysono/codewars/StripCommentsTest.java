package com.raysono.codewars;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

public class StripCommentsTest {

	private static final Random RANDOM = new Random();

	@Test
	public void stripComments() throws Exception {
		assertEquals(
				"apples, pears\ngrapes\nbananas",
				StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
		);

		assertEquals(
				"a\nc\nd",
				StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
		);

		assertEquals(
				"[\n\n\n]",
				StripComments.stripComments( "[\n \n#hugo  \n]", new String[] { "#", "$" } )
		);
	}

	@Test
	public void random() throws Exception {
		String[] comments = { "#", "$", "!", "-" };
		for ( int i = 0; i < 20; i++ ) {
			String test = randomString().replace( "1", comments[RANDOM.nextInt( 4 )] )
					.replace( "0", "\n" );
			assertEquals( StripComments.stripComments( test, comments ), StripComments.stripComments( test, comments ) );
		}
	}

	private static String randomString() {
		return new BigInteger( 100000, RANDOM ).toString( 16 )
				.replaceAll( "[2-9]", "\n" );
	}



}