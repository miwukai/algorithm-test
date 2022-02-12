package reverseWordsInAString_151;

public class Solution {
	public String reverseWords(String s) {
		String result;

		String[] words = s.split(" ");

		StringBuffer sb = new StringBuffer();

		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].length() > 0) {
				sb.append(words[i]);

				sb.append(" ");
			}
		}

		if (sb.length() > 0) {
			result = sb.substring(0, sb.length() - 1);
		} else {
			result = sb.toString();
		}

		return result;
	}
}
