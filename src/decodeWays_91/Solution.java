package decodeWays_91;

public class Solution {

	int result = 0;
	
	int[] nums;

	public int numDecodings(String s) {
		
		nums = new int[s.length()];

		if (s.startsWith("0") || s.endsWith("00")) {
			return result;
		} else {
			splitString(s);
		}

		return result;
	}

	void splitString(String s) {
		if (s.length() == 0) {
			result++;
		} else if (s.length() == 1) {
			if (!("0").equals(s)) {
				result++;
			}
		} else {
			String a = s.substring(1, s.length());

			if (!a.startsWith("0")) {
				splitString(a);
			}

			String b = s.substring(0, 2);
			String c = s.substring(2, s.length());

			if (("26").compareTo(b) >= 0 && !c.startsWith("0")) {
				splitString(c);
			}

		}

	}

	public static void main(String[] args) {
		String s = "11411";
		Solution so = new Solution();
		System.out.println(so.numDecodings(s));
	}
}
