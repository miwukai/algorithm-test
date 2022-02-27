package validateIPAddress_468;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public String validIPAddress(String queryIP) {

		Pattern ipv4P = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

		Matcher ipv4M = ipv4P.matcher(queryIP);

		if (ipv4M.matches()) {
			return "IPv4";
		} else {
			Pattern ipv6P = Pattern.compile("^([a-fA-F0-9]{1,4})(\\:[a-fA-F0-9]{1,4}){7}$");

			Matcher ipv6M = ipv6P.matcher(queryIP);

			if (ipv6M.matches()) {
				return "IPv6";
			}

		}

		return "Neither";
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
		
	}
}
