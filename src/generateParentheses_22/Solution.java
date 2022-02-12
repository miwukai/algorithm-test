package generateParentheses_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<String> result = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {

		char[] chars = new char[n * 2];

		chars[0] = '(';

		int count = 1;

		int k = 1;

		addChar(count, chars, k, 1, n);

		addChar(count, chars, k, -1, n);

		return result;
	}

	void addChar(int count, char[] chars, int k, int v, int n) {

		chars[count] = v == 1 ? '(' : ')';

		k = k + v;

		count++;

		if (count == n * 2) {
			if (k == 0 && v == -1) {
				result.add(String.valueOf(chars));
			}

			return;
		}

		if (k > n)
			return;

		if (k > 0) {
			addChar(count, chars, k, 1, n);

			addChar(count, chars, k, -1, n);
		} else if (k == 0) {
			addChar(count, chars, k, 1, n);
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();

		s.generateParenthesis(3);
	}
}
