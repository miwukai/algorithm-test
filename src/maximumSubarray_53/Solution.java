package maximumSubarray_53;

public class Solution {
	public int maxSubArray(int[] nums) {
		int max = nums[0];

		int tempResult = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (tempResult < 0) {
				tempResult = nums[i];
			} else {
				tempResult = tempResult + nums[i] < 0 ? 0 : tempResult + nums[i];
			}

			max = Math.max(max, tempResult);

		}

		return max;
	}
}
