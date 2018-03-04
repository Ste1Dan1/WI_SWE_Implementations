package webValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebValidatorModel {

	private final String IPv4PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	private final String IPv6PATTERN = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";

	private final String ADRESSPATTERN = "^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+[\\.])*[a-z]{2,3}?$";

	private final String PORTPATTERN = "[0-9]{1,5}";

	public boolean isValidPort(String newV) {

		Pattern portPattern = Pattern.compile(PORTPATTERN);
		Matcher portMatcher = portPattern.matcher(newV);

		try {
			int portNr = Integer.parseInt(newV);

			if (portMatcher.find() && portNr > 0 && portNr <= 65535) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isValidAdress(String newV) {

		Pattern IPv4Pattern = Pattern.compile(IPv4PATTERN);
		Matcher IPv4Matcher = IPv4Pattern.matcher(newV);
		Pattern adressPattern = Pattern.compile(ADRESSPATTERN);
		Matcher adressMatcher = adressPattern.matcher(newV);
		Pattern IPv6Pattern = Pattern.compile(IPv6PATTERN);
		Matcher IPv6Matcher = IPv6Pattern.matcher(newV);

		if (IPv4Matcher.find() || IPv6Matcher.find() || adressMatcher.find()) {
			return true;
		} else {
			return false;
		}

	}

}
