package com.raysono.codewars;

import java.util.Arrays;
import java.util.List;

class BreadcrumbGenerator {

	private static final String[] ignoreWords = {"the","of","in","from","by","with","and", "or", "for", "to", "at", "a"};
	private static final int maxlengthName = 30;

	static String generate_bc(String url, String separator) {

		final StringBuilder out = new StringBuilder();

		String[] urlParts = prepareUrl(url);

		// home
		if (urlParts.length > 0){
			out.append("<a href=\"/\">HOME</a>");
			out.append(separator);
		}

		// path
		computePath(urlParts, out, separator);

		// active Element
		appendActiveElement(urlParts, out);

		return out.toString();
	}

	static void appendActiveElement(String[] urlParts, StringBuilder out) {
		out.append("<span class=\"active\">");
		if (urlParts.length == 0){
			out.append("HOME");
		} else {
			out.append(formatName(urlParts[urlParts.length - 1]));
		}
		out.append("</span>");
	}

	static void computePath(String[] urlParts, StringBuilder out, String separator) {
		if (urlParts.length > 2) {
			String path = "";
			for (int i = 1; i < urlParts.length-1; i++) {
				path += urlParts[i] + "/";
				out.append("<a href=\"/");
				out.append(path);
				out.append("\">");
				out.append(formatName(urlParts[i]));
				out.append("</a>");
				out.append(separator);
			}
		}
	}

	static String[] prepareUrl(String url) {

		url = url.trim();

		if (url.contains("//")){
			url = url.split("//")[1];
		}

		String[] urlParts = url.split("/");

		if (urlParts[urlParts.length-1].contains("index.")) {
			urlParts = Arrays.copyOf(urlParts, urlParts.length-1);
		}

		if (urlParts.length == 1){
			urlParts = new String[0];
		} else {

			if (urlParts[urlParts.length - 1].contains("?")) {
				urlParts[urlParts.length - 1] = urlParts[urlParts.length - 1].split("\\?")[0];
			}
			if (urlParts[urlParts.length - 1].contains("#")) {
				urlParts[urlParts.length - 1] = urlParts[urlParts.length - 1].split("#")[0];
			}
			if (urlParts[urlParts.length - 1].contains(".")) {
				urlParts[urlParts.length - 1] = urlParts[urlParts.length - 1].split("\\.")[0];
			}
			if (urlParts[urlParts.length - 1].isEmpty()) {
				urlParts = Arrays.copyOf(urlParts, urlParts.length-1);
			}
		}

		return urlParts;
	}

	static String formatName(final String input){

		String retval;

		if (input.length() > maxlengthName) {

			final String[] urlParts = input.split("-");

			final List<String> ignoreList = Arrays.asList(ignoreWords);
			final StringBuilder acronyme = new StringBuilder();
			for (String part : urlParts) {
				if (!ignoreList.contains(part)) {
					acronyme.append(part.substring(0, 1).toUpperCase());
				}
			}
			retval = acronyme.toString();
		} else {
			retval = input.replace("-", " ");
		}

		return retval.toUpperCase();
	}
}
