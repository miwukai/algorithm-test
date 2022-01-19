package validParentheses_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {

		Map<Character, Character> map = new HashMap<Character, Character>();

		map.put(')', '(');

		map.put(']', '[');

		map.put('}', '{');

		if (s == null) {

			return true;

		} else {

			Stack<Character> parentheses = new Stack<Character>();

			char[] chars = s.toCharArray();

			for (char c : chars) {

				if (parentheses.size() != 0 && parentheses.peek().equals(map.get(c))) {

					parentheses.pop();

				} else {

					parentheses.push(c);

				}
			}

			if (parentheses.size() == 0) {
				return true;
			}
		}

		return false;

	}
}
