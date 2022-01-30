package bestTimeToBuyAndSellStock_121;

public class Solution {
	public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] differences = new int[prices.length];
		differences[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			differences[i] = prices[i] - prices[i - 1];
		}

		int result = 0;
		for(int j = 1;j<differences.length;j++) {
			differences[j] += Math.max(differences[j-1], 0);
			result  = Math.max(result,differences[j]);
		}
		
		return result;
    }
}
