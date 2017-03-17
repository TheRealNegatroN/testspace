package com.raysono.codewars;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BreadcrumbGeneratorTest {

	@Test
	public void testPrepareUrl(){
		final String[] urls = {
				"mysite.com/pictures/holidays.html",
				"www.agcpartners.co.uk/users/GiacomoSorbi?ref=CodeWars",
				"www.microsoft.com/docs/index.htm#top",
				"mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.asp#top",
				"www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi",
				"www.agcpartners.co.uk/",
				"http://mysite.com/Biotechnology-to-research/",
				"https://www.mysite.com/users/research-eurasian-bladder-for/secret-page.asp"
		};

		final String[][] anss = {
				{"mysite.com", "pictures", "holidays"},
				{"www.agcpartners.co.uk", "users", "GiacomoSorbi"},
				{"www.microsoft.com", "docs"},
				{"mysite.com", "very-long-url-to-make-a-silly-yet-meaningful-example", "example"},
				{"www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com", "users", "giacomo-sorbi"},
				{},
				{"mysite.com", "Biotechnology-to-research"},
				{"www.mysite.com", "users", "research-eurasian-bladder-for", "secret-page"}
		};

		for (int i = 0; i < urls.length; i++) {
			System.out.println(" \nTest with : " + urls[i]);
			final String[] actual = BreadcrumbGenerator.prepareUrl(urls[i]);
			assertArrayEquals(anss[i], actual);
		}

	}

	@Test
	public void testAcronyme() {
		final String input = "very-long-url-to-make-a-silly-yet-meaningful-example";
		final String expected = "VLUMSYME";
		final String actual = BreadcrumbGenerator.formatName(input);

		assertEquals(expected, actual);
	}

	@Test
	public void testAcronymeShort() {
		final String input = "normal-url";
		final String expected = "NORMAL URL";
		final String actual = BreadcrumbGenerator.formatName(input);

		assertEquals(expected, actual);
	}

	@Test
	public void testAppendActiveElement() {

		final String[] urlParts = {"hugo", "egon"};
		final StringBuilder builder = new StringBuilder();

		final String expected = "<span class=\"active\">EGON</span>";
		BreadcrumbGenerator.appendActiveElement(urlParts, builder);

		assertEquals(expected, builder.toString());
	}

	@Test
	public void testAppendActiveElementEmpty() {

		final String[] urlParts = new String[0];
		final StringBuilder builder = new StringBuilder();

		final String expected = "<span class=\"active\">HOME</span>";
		BreadcrumbGenerator.appendActiveElement(urlParts, builder);

		assertEquals(expected, builder.toString());
	}

	@Test
	public void testComputePath() {
		final String[] urlParts = {"hugo", "egon", "hella", "horst"};
		final StringBuilder builder = new StringBuilder("");
		final String separator = " # ";

		final String expected = "<a href=\"/egon/\">EGON</a> # <a href=\"/egon/hella/\">HELLA</a> # ";
		BreadcrumbGenerator.computePath(urlParts, builder, separator);
		assertEquals(expected, builder.toString());
	}

	@Test
	public void testComputePathEmpty() {
		final String[] urlParts = new String[0];
		final StringBuilder builder = new StringBuilder("");
		final String separator = " # ";

		final String expected = "";
		BreadcrumbGenerator.computePath(urlParts, builder, separator);
		assertEquals(expected, builder.toString());
	}

	@Test
	public void examplesTests() {
		// assertEquals("expected", "actual");

		final String[] urls = {
				"mysite.com/pictures/holidays.html",
				"www.agcpartners.co.uk/users/GiacomoSorbi?ref=CodeWars",
				"www.microsoft.com/docs/index.htm#top",
				"mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.asp#top",
				"www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi",
				"www.agcpartners.co.uk/",
				"http://raysono.com/Biotechnology-to-research/",
				"http://raysono.com/users/research-eurasian-bladder-for/secret-page.asp"
		};

		final String[] seps = {" : ", " / ", " * ", " > ", " + ", " * ", " . ", " # "};

		final String[] anss = {
				"<a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>",
				"<a href=\"/\">HOME</a> / <a href=\"/users/\">USERS</a> / <span class=\"active\">GIACOMOSORBI</span>",
				"<a href=\"/\">HOME</a> * <span class=\"active\">DOCS</span>",
				"<a href=\"/\">HOME</a> > <a href=\"/very-long-url-to-make-a-silly-yet-meaningful-example/\">VLUMSYME</a> > <span " +
						"class=\"active\">EXAMPLE</span>",
				"<a href=\"/\">HOME</a> + <a href=\"/users/\">USERS</a> + <span class=\"active\">GIACOMO SORBI</span>",
				"<span class=\"active\">HOME</span>",
				"<a href=\"/\">HOME</a> . <span class=\"active\">BIOTECHNOLOGY TO RESEARCH</span>",
				"<a href=\"/\">HOME</a> # <a href=\"/users/\">USERS</a> # <a href=\"/users/research-eurasian-bladder-for/\">RESEARCH " +
						"EURASIAN BLADDER FOR</a> # <span class=\"active\">SECRET PAGE</span>"};

		for (int i = 0; i < urls.length; i++) {
			System.out.println(" \nTest with : " + urls[i]);
			final String actual = BreadcrumbGenerator.generate_bc(urls[i], seps[i]);
			if (!actual.equals(anss[i])) {
				System.out.println(String.format("Expected : %s", reformat(anss[i])));
				System.out.println(String.format("Actual :   %s", reformat(actual)));
			}
			assertEquals(anss[i], actual);
		}
	}

	private String reformat(String s) {
		return s.replace("<", "<");
	}

}