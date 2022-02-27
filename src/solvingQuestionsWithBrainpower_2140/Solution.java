package solvingQuestionsWithBrainpower_2140;

public class Solution {
	public long mostPoints(int[][] questions) {
		long[] pointArray = new long[questions.length];

		long result = questions[questions.length - 1][0];

		pointArray[questions.length - 1] = questions[questions.length - 1][0];

		for (int n = questions.length - 2; n >= 0; n--) {
			int m = n + questions[n][1] + 1;

			if (m > questions.length - 1) {
				pointArray[n] = questions[n][0];
			} else {
				pointArray[n] = questions[n][0] + pointArray[m];
			}

			pointArray[n] = Math.max(pointArray[n], pointArray[n + 1]);

			result = Math.max(pointArray[n], result);
		}

		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int[][] questions = new int[100000][2];

		for (int i = 0; i < questions.length; i++) {
			questions[i] = new int[] { 100000, 1 };
		}

		System.out.println(s.mostPoints(questions));
	}
}
