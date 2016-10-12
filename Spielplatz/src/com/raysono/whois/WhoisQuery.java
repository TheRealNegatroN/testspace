package com.raysono.whois;

import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhoisQuery {

	private final static Pattern pattern;

	// regex whois parser
	private static final String WHOIS_SERVER_PATTERN = "Whois Server:\\s(.*)";

	static {
		pattern = Pattern.compile(WHOIS_SERVER_PATTERN);
	}

	public static void main(String[] args) throws Exception {

		WhoisQuery whoisQuery = new WhoisQuery();

		String result = whoisQuery.getWhois("nic.man");

		System.out.println("---------");
		System.out.println(result);
		System.out.println("---------");

	}

	private String getWhois(String domainName) {

		StringBuilder result = new StringBuilder("");
		WhoisClient whois = new WhoisClient();

		try {
			// whois.connect(WhoisClient.DEFAULT_HOST);
			whois.connect("whois-fe.man.tango.knipp.de", WhoisClient.DEFAULT_PORT);

			// String whoisData1 = whois.query("-T dn " + domainName);
			String whoisData1 = whois.query(domainName);
			result.append(whoisData1);
			whois.disconnect();

			result.append("-#-#-#-#-#-");

			String whoisServerUrl = getWhoisServer(whoisData1);
			if (!whoisServerUrl.equals("")) {

				String whoisData2 = queryWithWhoisServer(domainName, whoisServerUrl);

				result.append(whoisData2);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	private String queryWithWhoisServer(String domainName, String whoisServer) {

		String result = "";
		WhoisClient whois = new WhoisClient();
		try {

			whois.connect(whoisServer);
			result = whois.query(domainName);
			whois.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

	private String getWhoisServer(String whois) {

		String result = "";

		Matcher matcher = pattern.matcher(whois);

		// get last whois server
		while (matcher.find()) {
			result = matcher.group(1);
		}
		return result;
	}

}
