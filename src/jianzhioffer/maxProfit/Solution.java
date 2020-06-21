package jianzhioffer.maxProfit;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] min = new int[prices.length], dp = new int[prices.length];
        min[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min[i - 1]);
        }
        return dp[prices.length - 1];
    }
}