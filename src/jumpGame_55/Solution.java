package jumpGame_55;

public class Solution {
	public boolean canJump(int[] nums) {
        int n = 0;
		for(int i = 0;i<nums.length;i++) {
			
			if(nums[i]>0) {
				n = Math.max(n,nums[i]+i);
				if(n>=nums.length){
					return true;
				}
			}else {
				if(i > n || (i == n && i != nums.length-1)) {
					return false;
				}else {
					continue;
				}
			}
			
		}
		
		return true;
    }
}
