package jianzhioffer.maxArea;

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2){
            return 0;
        }
        int[] dp = new int[height.length];
        dp[0] = 0;
        dp[1] = Math.min(height[0],height[1]);
        for (int i = 2; i < height.length; i++) {
            int mx = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                mx = Math.max(mx, Math.min(height[i],height[j]) * (i - j));
            }
            dp[i] = Math.max(mx,dp[i-1]);
        }
        return dp[height.length - 1];
    }

    public static void main(String[] args) {
        new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}