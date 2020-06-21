package jianzhioffer.findRepeatNumber;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        boolean[] bitmap = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (bitmap[nums[i]])
                return nums[i];
            bitmap[nums[i]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {


    }
}