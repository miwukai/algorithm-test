package rotateImage_48;

public class Solution {
	public void rotate(int[][] matrix) {
        for (int r = 0; r < (matrix.length + 1) / 2; r++) {
			for (int c = r; c < matrix.length - 1 -r; c++) {

				int oriVal = matrix[r][c];

				int newRow = r;
				int newColumn = c;

				for (int i = 1; i < 5; i++) {

					int j = newRow;
					newRow = newColumn;
					newColumn = matrix.length - 1 - j;

					int temp = matrix[newRow][newColumn];

					matrix[newRow][newColumn] = oriVal;

					oriVal = temp;

				}

			}

		}
    }
}

//0,0 0,n-1 n-1,n-1 n-1,0
// 0,1 1,n-1
// 0,2 2,n-1
// 0,n-1 n-1,n-1

// 1,0 0,n-1-1
// 1,1 1,n-1-1 
