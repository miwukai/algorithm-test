package TwoSum_1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            int a = target - nums[i];

            if(map.containsKey(a)){
                return new int[] {map.get(a),i};
            }

            map.put(nums[i],i);
        }

        return null;
    }
}
