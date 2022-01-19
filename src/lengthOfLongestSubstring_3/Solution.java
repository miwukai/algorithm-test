package lengthOfLongestSubstring_3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {

		if(s == null ||s.length() == 0) {
			return 0;
		}
		
		char[] chars = s.toCharArray();
		
		int i = 0;
		
		List<Character> tempList = new ArrayList<Character>();
		
		for(int j = 0;j<chars.length && chars.length - j>i;j++) {
			int m = 0;
			for(int k = j;k<chars.length;k++) {
				if(!tempList.contains(chars[k])){
					m++;
					tempList.add(chars[k]);
				}else {
					tempList.clear();
					break;
				}
			}
			
			i = Math.max(i,m);
			
		}
		
		return i;
	}
	
	public static void main(String[] args) {
		
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		
	}
}
