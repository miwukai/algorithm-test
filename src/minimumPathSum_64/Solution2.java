package minimumPathSum_64;

public class Solution2 {

	int[][] pathLengths;

	public int minPathSum(int[][] grid) {

		int maxM = grid.length;

		int maxN = grid[0].length;

		pathLengths = new int[maxM][maxN];

		sumPathLength(grid, maxM, maxN, maxM - 1, maxN - 1);

		return pathLengths[maxM - 1][maxN - 1];
	}

	void sumPathLength(int[][] grid, int maxM, int maxN, int m, int n) {
		if (m == 0 && n == 0) {
			pathLengths[m][n] = grid[m][n];
			return;
		}

		if (m < 0 || n < 0)
			return;

		if (pathLengths[m][n] > 0)
			return;

		sumPathLength(grid, maxM, maxN, m - 1, n);

		sumPathLength(grid, maxM, maxN, m, n - 1);

		pathLengths[m][n] = Integer.MAX_VALUE;

		if (m > 0)
			pathLengths[m][n] = Math.min(pathLengths[m][n], pathLengths[m - 1][n] + grid[m][n]);

		if (n > 0)
			pathLengths[m][n] = Math.min(pathLengths[m][n], pathLengths[m][n - 1] + grid[m][n]);
	}

	public static void main(String[] args) {
		int[][] i = new int[][] { { 3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3 },
				{ 0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2 }, { 8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9 },
				{ 1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7 }, { 8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8 },
				{ 4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9 }, { 6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1 },
				{ 8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3 }, { 9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3 },
				{ 0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8 }, { 4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3 },
				{ 2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3 }, { 0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3 },
				{ 0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5 }, { 6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2 },
				{ 7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0 }, { 3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0 },
				{ 5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7 } };

		Solution2 s = new Solution2();

		System.out.println(s.minPathSum(i));

	}
}
