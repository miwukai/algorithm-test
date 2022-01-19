package findKthLargest_215;

public class Solution2 {
	
	public static void main(String[] args) {
		int[] nums = new int[] {7,6,5,4,3,2,1};
		int k = 5;
		Solution2 sol = new Solution2();
		System.out.println(sol.findKthLargest(nums,k));
	}

	public int findKthLargest(int[] nums, int k) {

		int lo = 0;

		int hi = nums.length - 1;

		while (lo < hi) {
			int i = partition(nums, lo, hi);

			if (i == k - 1) {
				return nums[i];
			} else if (i > k - 1) {
				hi = i - 1;
			} else if (i < k - 1) {
				lo = i + 1;
			}
		}

		return nums[k];
	}

	public int partition(int[] nums, int lo, int hi) {

		int v = nums[lo];

		int i = lo;
 
		int j = hi+1;

		while (true) {
			while (nums[++i] > v) {
				if (i == hi) {
					break;
				}
			}

			while (nums[--j] < v) {
				if (j == lo) {
					break;
				}
			}

			if (i >= j) {
				break;
			}

			exch(nums, i, j);

		}

		exch(nums, lo, j);

		return j;
	}

	public void exch(int[] nums, int lo, int hi) {
		int t = nums[lo];

		nums[lo] = nums[hi];

		nums[hi] = t;
	}

}
