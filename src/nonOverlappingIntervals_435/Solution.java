package nonOverlappingIntervals_435;

import java.util.Arrays;

public class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int b = intervals[0][1];
		int res = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < b) {
				res++;
				b = Math.min(b, intervals[i][1]);
			} else {
				b = intervals[i][1];
			}
		}

		return res;
	}
}
