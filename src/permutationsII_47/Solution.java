package permutationsII_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] nums) {

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				List<Integer> li = new ArrayList<Integer>();
				List<Integer> indexList = new ArrayList<Integer>();
				permute(nums, i, li, indexList);
			}
		}

		return result;
	}

	void permute(int[] nums, int k, List<Integer> li, List<Integer> li2) {
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(li);
		list.add(nums[k]);

		List<Integer> indexList = new ArrayList<Integer>();
		indexList.addAll(li2);
		indexList.add(k);

		if (list.size() == nums.length) {
			result.add(list);
			return;
		}

		Integer v = null;

		for (int i = 0; i < nums.length; i++) {
			if (!indexList.contains(i) && (v == null || nums[i] != v)) {
				v = nums[i];
				permute(nums, i, list, indexList);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2 };
		
		Solution s = new Solution();
		
		s.permuteUnique(nums);
	}
}
