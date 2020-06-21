package dailyKill.dailyTemperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] rec = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                int preIndex = stack.pop();
                rec[preIndex] = i - preIndex;
            }

            stack.push(i);
        }
        while(!stack.isEmpty()){
            rec[stack.pop()] = 0;
        }
        return rec;
    }

    public static void main(String[] args) {
        new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
