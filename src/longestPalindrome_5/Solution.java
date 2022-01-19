package longestPalindrome_5;

public class Solution {
	public String longestPalindrome(String s) {
		String ss = new String();

		char[] chars = s.toCharArray();

		if (chars.length <= 1) {
			return s;
		}

		for (int i = 1; i < chars.length; i++) {
			if (i - 1 >= 0 && chars[i] == chars[i - 1]) {
				for (int j = 2;; j++) {
					if (i - j >= 0 && i + j - 1 < chars.length && chars[i - j] == chars[i + j - 1]) {
						continue;
					} else {

						String tempS = s.substring(i - j + 1, i + j - 1);
						if (tempS.length() > ss.length()) {
							ss = tempS;
						}
						break;

					}
				}

			}
			if (i - 1 >= 0 && i + 1 < chars.length && chars[i + 1] == chars[i - 1]) {
				for (int j = 2;; j++) {
					if (i - j >= 0 && i + j < chars.length && chars[i + j] == chars[i - j]) {
						continue;
					} else {
						String tempS = s.substring(i - j + 1, i + j);
						if (tempS.length() > ss.length()) {
							ss = tempS;
						}
						break;
					}
				}
			}

		}

		if (ss.length() == 0) {
			ss = s.substring(0, 1);
		}

		return ss;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String ss = solution.longestPalindrome("ccc");
		System.out.println(ss);
	}

}
