package courseSchedule_207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	boolean[] marked;

	boolean[] onStack;

	boolean result = true;

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> preMap = new HashMap<>();

		for (int i = 0; i < prerequisites.length; i++) {
			if (preMap.containsKey(prerequisites[i][0])) {
				preMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
			} else {
				List<Integer> li = new ArrayList<>();
				li.add(prerequisites[i][1]);
				preMap.put(prerequisites[i][0], li);
			}
		}

		marked = new boolean[numCourses];

		onStack = new boolean[numCourses];

		for (int j = 0; j < numCourses; j++) {
			if (!marked[j] && result) {
				dfs(preMap, j);
			}
		}

		return result;

	}

	void dfs(Map<Integer, List<Integer>> preMap, int j) {

		if (onStack[j] == false) {

			if (preMap.containsKey(j)) {
				onStack[j] = true;
				for (int k : preMap.get(j)) {
					if (!marked[k] && result) {
						dfs(preMap, k);
					}
				}

				onStack[j] = false;

			}
			
			marked[j] = true;
			
		} else {
			result = false;
			
			return;
		}

	}

	public static void main(String[] args) {
		int[][] i = new int[][] { { 1, 0 }, { 0, 1 } };

		Solution s = new Solution();

		System.out.println(s.canFinish(2, i));
	}

}
