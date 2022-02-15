package mergeIntervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
	public int[][] merge(int[][] intervals) {
        int ind = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[ind][1] >= intervals[i][0]) {
                intervals[ind][1] = Math.max(intervals[ind][1], intervals[i][1]);
            } else {
                list.add(intervals[ind]);
                ind = i;
            }
        }
        list.add(intervals[ind]);
        return list.toArray(new int[list.size()][]);
    }
}
