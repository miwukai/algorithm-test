package combinationSum_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<Integer> li = new ArrayList<>();
		
		for (int i = 0; i < candidates.length; i++) {
			tryCandidate(candidates, i, li, target);
		}

		return result;
	}

	void tryCandidate(int[] candidates, int index, List li, int target) {

		List<Integer> list = new ArrayList<>();
		
		list.addAll(li);
		
		list.add(candidates[index]);

		target = target - candidates[index];

		if (target == 0) {
			result.add(list);
		} else if (target > 0) {
			for (int i = index; i < candidates.length; i++) {
				tryCandidate(candidates, i, list, target);
			}
		}

	}

	public static void main(String[] args) {
		int[] candidates = new int[] { 2, 3, 6, 7 };

		int target = 7;

		Solution s = new Solution();

		List<List<Integer>> output = s.combinationSum(candidates, target);
	}

}
