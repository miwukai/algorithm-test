package decodeWays_91;

public class Solution2 {

	int[] nums;

	public int numDecodings(String s) {

		nums = new int[s.length() + 1];

		if (s.startsWith("0") || s.contains("00") || s.contains("30") || s.contains("40") || s.contains("50")
				|| s.contains("60") || s.contains("70") || s.contains("80") || s.contains("90")) {
			return 0;
		} else {
			int result = 1;
			int[] subStringLength = new int[s.length() + 1];
			int i = 0;
			int count = 0;
			char[] chars = s.toCharArray();
			for (int j = 0; j < chars.length; j++) {
				if (('0') == chars[j]) {
					count--;
					subStringLength[i] = count;
					count = 0;
					i++;
				} else if (('2') >= chars[j]) {
					count++;
				} else {
					if (j == 0 || ('1') == chars[j - 1]) {
						count++;
						subStringLength[i] = count;
						count = 0;
						i++;
					} else if (('2') == chars[j - 1]) {
						if (('7') > chars[j]) {
							count++;
						}
						subStringLength[i] = count;
						count = 0;
						i++;
					}
				}
			}
			subStringLength[i] = count;

			for (int num : subStringLength) {
				if (num > 0) {
					result = result * getNums(num);
				}

			}

			return result;

		}

	}

	int getNums(int num) {

		int r = nums[num];

		if (r == 0) {
			if (num == 1) {
				r = 1;
			} else if (num == 2) {
				r = 2;
			} else {
				r = getNums(num - 1) + getNums(num - 2);
			}

			nums[num] = r;
		}

		return r;

	}

}
