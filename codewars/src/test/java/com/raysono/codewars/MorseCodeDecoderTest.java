package com.raysono.codewars;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MorseCodeDecoderTest {

	@Test
	public void decodeSingleCharacter() throws Exception {
		assertThat(".... should be H", MorseCodeDecoder.decode("...."), is("H"));
		assertThat(". should be E", MorseCodeDecoder.decode("."), is("E"));
		assertThat("-.-- should be Y", MorseCodeDecoder.decode("-.--"), is("Y"));
		assertThat(".--- should be J", MorseCodeDecoder.decode(".---"), is("J"));
		assertThat("..- should be U", MorseCodeDecoder.decode("..-"), is("U"));
		assertThat("-.. should be D", MorseCodeDecoder.decode("-.."), is("D"));
	}

	@Test
	public void decodeWord() throws Exception {
		assertThat(".... . -.-- should be HEY", MorseCodeDecoder.decode(".... . -.--"), is("HEY"));
		assertThat(".--- ..- -.. . should be JUDE", MorseCodeDecoder.decode(".--- ..- -.. ."), is("JUDE"));
	}

	@Test
	public void decodeSOS() throws Exception {
		assertThat(MorseCodeDecoder.decode("...---..."), is("SOS"));
	}

	@Test
	public void testSentence() {
		assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
		assertThat(MorseCodeDecoder.decode("...---...    .... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
	}
}