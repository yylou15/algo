package weeklyContest.w195.numSubseq;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        BigInteger sum = new BigInteger(String.valueOf(0));
        while (start <= end) {
            if (nums[start] + nums[end] <= target) {
                int gap = end - start;
                if (gap == 0){
                    gap = 1;
                }
                sum = sum.add(new BigInteger(String.valueOf((int)Math.pow(2, gap - 1))));
                start++;
            } else {
                end--;
            }
        }
        return sum.mod(new BigInteger(String.valueOf((int)Math.pow(10,9) + 7))).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubseq(new int[] {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14,22}, 22));
    }
}