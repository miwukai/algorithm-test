package findKthLargest_215;

public class Solution {
	
	public static void main(String[] args) {
		int[] nums = new int[] {7,6,5,4,3,2,1};
		int k = 5;
		Solution sol = new Solution();
		System.out.println(sol.findKthLargest(nums,k));
	}
	
	public int findKthLargest(int[] nums, int k) {
		
		MinPQ mpq = new MinPQ(k + 1);
		
		for(int i : nums) {
			mpq.insert(i);
			if(mpq.size() > k) {
				mpq.delMin();
			}
		}
		
		return mpq.min();
	}
	
	public class MinPQ {
		private Integer[] pq;
		private int n = 0;
		
		public MinPQ(int size) {
			pq = new Integer[size + 1];
		}
		
		public void insert(int i) {
			pq[++n] = i;
			swim(n);
		}
		
		public int delMin() {
			int min = pq[1];
			exch(1,n--);
			pq[n+1] = null;
			sink(1);
			return min;
		}
		
		public int min() {
			return pq[1];
		}
		
		public int size() {
			return n;
		}
		
		public void swim(int m) {
			while(m > 1 && pq[m/2] > pq[m]) {
				exch(m/2,m);
				m = m/2;
			}
		}
		
		public void sink(int m) {
			while(2*m <= n) {
				int j = 2*m;
				if(j < n && pq[j] > pq[j+1])j++;
				if(pq[m] < pq[j]) break;
				exch(m,j);
				m = j;
			}
		}
		
		public void exch(int k0, int k1) {
			int v0 = pq[k0];
			pq[k0] = pq[k1];
			pq[k1] = v0;
		}
	}
}
