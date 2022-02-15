package mergeIntervals_56;

public class Solution {
	public int[][] merge(int[][] intervals) {

		int n = intervals.length;

		int[][] result = new int[n][2];

		if (n == 1)
			return intervals;

		int[][] a1 = new int[n / 2][2];

		int[][] a2 = new int[n - n / 2][2];

		for (int i = 0; i < n / 2; i++) {
			a1[i] = intervals[i];
		}

		for (int j = 0; j < n - n / 2; j++) {
			a2[j] = intervals[j + n / 2];
		}

		int[][] b1 = merge(a1);
		int[][] b2 = merge(a2);

		int u = 0;

		int v = 0;

		int k = 0;

		while (u < b1.length || v < b2.length) {
			if (u >= b1.length) {
				if (k > 0 && result[k - 1][0] <= b2[v][0] && result[k - 1][1] >= b2[v][0]) {
					result[k - 1][1] = Math.max(result[k - 1][1], b2[v][1]);
					v++;
				} else {
					result[k] = b2[v];
					k++;
					v++;
				}
			} else if (v >= b2.length) {
				if (k > 0 && result[k - 1][0] <= b1[u][0] && result[k - 1][1] >= b1[u][0]) {
					result[k - 1][1] = Math.max(result[k - 1][1], b1[u][1]);
					u++;
				} else {
					result[k] = b1[u];
					k++;
					u++;
				}
			} else if (b1[u][0] <= b2[v][0] && b1[u][1] >= b2[v][0]) {
				b1[u][1] = Math.max(b1[u][1], b2[v][1]);
				v++;
			} else if (b2[v][0] <= b1[u][0] && b2[v][1] >= b1[u][0]) {
				b2[v][1] = Math.max(b1[u][1], b2[v][1]);
				u++;
			} else if (b1[u][1] < b2[v][0]) {
				if (k > 0 && result[k - 1][0] <= b1[u][0] && result[k - 1][1] >= b1[u][0]) {
					result[k - 1][1] = Math.max(result[k - 1][1], b1[u][1]);
					u++;
				} else {
					result[k] = b1[u];
					k++;
					u++;
				}
			} else if (b2[v][1] < b1[u][0]) {
				if (k > 0 && result[k - 1][0] <= b2[v][0] && result[k - 1][1] >= b2[v][0]) {
					result[k - 1][1] = Math.max(result[k - 1][1], b2[v][1]);
					v++;
				} else {
					result[k] = b2[v];
					k++;
					v++;
				}
			}
		}

		int[][] trueResult = new int[k][2];

		for (int r = 0; r < k; r++) {
			trueResult[r] = result[r];
		}

		return trueResult;
	}

	public static void main(String[] args) {
		int[][] i = new int[][] {{3,3},{1,1},{0,2},{2,2},{1,2},{1,3},{1,1},{3,3},{2,3},{4,6}};

		Solution s = new Solution();

		s.merge(i);
	}

}
