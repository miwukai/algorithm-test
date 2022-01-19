package threeSum_15;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int partition(int arr[], int l, int r) {
		int temp = arr[l];
		while (l < r) {
			while (l < r && arr[r] > temp) {
				r--; // 反复左移r
			}
			arr[l] = arr[r];

			while (l < r && arr[l] <= temp) {
				l++; // 反复右移l
			}
			arr[r] = arr[l];

		}
		arr[l] = temp;// temp中元素回位
		return l;// 返回相遇位置

	}

	void quickSort(int arr[], int l, int r) {
		if (r > l) {
			int pos = partition(arr, l, r);
			quickSort(arr, l, pos - 1);
			quickSort(arr, pos + 1, r);
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> li = new ArrayList<List<Integer>>();

		if (nums != null && nums.length > 2) {

			quickSort(nums, 0, nums.length - 1);

			int i = 0;

			int m = i + 1;

			int j = nums.length - 1;

			int temp = i;

			while (i + 1 < j && i < m && m < j && nums[i] <= 0 && nums[j] >= 0) {

				if (nums[i] + nums[m] + nums[j] > 0) {
					j--;
					i = temp;
					m = i + 1;
				} else if (nums[i] + nums[m] + nums[j] < 0) {
					if (m + 1 < j) {
						m++;
					} else {
						i++;
						m = i + 1;
					}
				} else {
					List<Integer> list = new ArrayList<Integer>();

					list.add(nums[i]);

					list.add(nums[m]);

					list.add(nums[j]);

					li.add(list);

					int tempm = m;

					while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
						i++;
						m = i + 1;
					}
					while (j > 0 && nums[j] == nums[j - 1]) {
						j--;
					}
//					if (nums[tempm] > 0) {
//						temp = i;
//						i++;
//						m = i + 1;
//					} 
//					else if (nums[tempm] < 0) {
//						j--;
//						i = temp;
//						m = i + 1;
//					} 
//					else {
//						temp = i;
					i++;
					m = i + 1;
					
//					}
				}
			}

		}

		return li;
	}

}
