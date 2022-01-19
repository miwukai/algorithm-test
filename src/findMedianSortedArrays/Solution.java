package findMedianSortedArrays;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;

		int n = nums2.length;

		int length = m + n;

		int p = 0;

		int q = 0;

		// solution one
//		List<Integer> a = Arrays.stream(nums1).boxed().collect(Collectors.toList());
//		
//		List<Integer> b = Arrays.stream(nums2).boxed().collect(Collectors.toList());
//		
//		a.addAll(b);
//		
//		Collections.sort(a);
//		
//		if (length % 2 == 0) {
//			return (a.get((length / 2)-1) + a.get(length / 2)) / 2.0;
//		} else {
//			return a.get(length / 2);
//		}

		if (m == 0) {
			if (n % 2 == 0) {
				return (nums2[(n / 2) - 1] + nums2[n / 2]) / 2.0;
			} else {
				return nums2[n / 2];
			}
		} else if (n == 0) {
			if (m % 2 == 0) {
				return (nums1[(m / 2) - 1] + nums1[m / 2]) / 2.0;
			} else {
				return nums1[m / 2];
			}
		} else {

			if (length % 2 != 0) {
				int i = 1 + (length / 2);

				for (int j = 0; j < i; j++) {
					if (p < nums1.length && q < nums2.length) {
						if (nums1[p] < nums2[q]) {
							if (j == i - 1) {
								return nums1[p];
							}
							p = p + 1;
						} else {
							if (j == i - 1) {
								return nums2[q];
							}
							q = q + 1;
						}
					} else {
						if (p == nums1.length) {
							if (i - j - 1 == 0) {
								return nums2[q];
							} else {
								return nums2[q+i-j-1];
							}
						} else if (q == nums2.length) {
							if (i - j - 1 == 0) {
								return nums1[p];
							} else {
								return nums1[p+i-j-1];
							}

						}
					}
				}

//				while (p + q + 2 <= i) {
//					if (p < nums1.length && q < nums2.length) {
//						if (nums1[p] < nums2[q]) {
//							if (p + q + 2 == i) {
//								return nums2[q];
//							}
//							p = p + 1;
//						} else {
//							if (p + q + 2 == i) {
//								return nums1[p];
//							}
//							q = q + 1;
//						}
//					} else if (p == nums1.length) {
//
//					} else if (q == nums2.length) {
//
//					}
//				}
			} else {
				int i = 1 + (length / 2);

				int j = 1;
						
				int k = 0;

				while(j <= i) {
					if (p < nums1.length && q < nums2.length) {

						if (nums1[p] < nums2[q]) {
							if (j == i) {
								return (nums1[p] + k) / 2.0;
							}
							k = nums1[p];
							p = p + 1;
						} else {
							if (j == i) {
								return (nums2[q] + k) / 2.0;
							}
							k = nums2[q];
							q = q + 1;
						}
						
						j++;
					} else {
						if (p == nums1.length) {
							if (i - j == 0) {
								return (nums2[q] + k) / 2.0;
							} else {
								return (nums2[q+i-j]+nums2[q+i-j-1])/2.0;
							}
						} else if (q == nums2.length) {
							if (i - j == 0) {
								return (nums1[p] + k) / 2.0;
							} else {
								return (nums1[p+i-j]+nums1[p+i-j-1])/2.0;
							}

						}
					}

				}

//				int j = 1 + (length / 2);
//
//				while (p + q + 2 <= j) {
//					if (nums1[p] < nums2[q]) {
//						if (p + q + 2 == j) {
//							return (nums1[p] + nums2[q]) / 2.0;
//						}
//
//						p = (p + 1) < nums1.length ? p + 1 : p;
//
//					} else {
//						if (p + q + 2 == j) {
//							return (nums1[p] + nums2[q]) / 2.0;
//						}
//						q = (q + 1) < nums2.length ? q + 1 : q;
//					}
//				}

			}
		}

		return 0.0;

	}

	public static void main(String[] args) {
//		int[] nums1 = new int[] { 1, 3, 5, 17 };
//		int[] nums2 = new int[] { 3, 4 };

		int[] nums1 = new int[] { 1 };
		int[] nums2 = new int[] { 2, 3, 4 ,5};

//		int[] nums1 = new int[] {1,2};
//		int[] nums2 = new int[] {3,4,5,6 };

		Solution s = new Solution();

		double d = s.findMedianSortedArrays(nums1, nums2);

		System.out.println(d);
	}
}
