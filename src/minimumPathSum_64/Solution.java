package minimumPathSum_64;

public class Solution {

	int result = 0;

	int maxM = 0;

	int maxN = 0;

	public int minPathSum(int[][] grid) {

		maxM = grid[0].length;

		maxN = grid.length;

		int m = 1;

		int n = 1;

		int pathLength = grid[0][0];

		if (m == maxM && n == maxN) {
			result = pathLength;
		} else if (m == maxM) {
			move(m, n, -1, pathLength, grid);
		} else if (n == maxN) {
			move(m, n, 1, pathLength, grid);
		} else {
			move(m, n, -1, pathLength, grid);
			move(m, n, 1, pathLength, grid);
		}

		return result;
	}

	void move(int m, int n, int direction, int pathLength, int[][] grid) {

		if (result != 0 && pathLength >= result) {
			return;
		}

		if (direction == 1) {
			m++;
			pathLength = pathLength + grid[n - 1][m - 1];
		} else if (direction == -1) {
			n++;
			pathLength = pathLength + grid[n - 1][m - 1];
		}

		if (m == maxM && n == maxN) {
			if (result == 0) {
				result = pathLength;
			} else {
				result = Math.min(pathLength, result);
			}

		} else if (m == maxM) {
			move(m, n, -1, pathLength, grid);
		} else if (n == maxN) {
			move(m, n, 1, pathLength, grid);
		} else {
			move(m, n, -1, pathLength, grid);
			move(m, n, 1, pathLength, grid);
		}
	}

	public static void main(String[] args) {
		int[][] i = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		Solution s = new Solution();

		System.out.println(s.minPathSum(i));

	}
}
