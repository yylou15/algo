package weeklyContest.w195.canArrange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        if (arr == null) {
            return false;
        }
        int[] mod = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i] % k;
            if (tmp < 0) {
                tmp += k;
            }
            mod[i] = tmp;
        }
        Map<Integer, List<Integer>> modToIndex = new HashMap<>();
        for (int i = 0; i < k; i++) {
            modToIndex.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            modToIndex.get(mod[i]).add(arr[i]);
        }
        for (int i = 1; i < (k + 1) / 2; i++) {
            if (modToIndex.get(i).size() != modToIndex.get(k - i).size()) {
                return false;
            }
        }
        if (k % 2 == 0 && modToIndex.get(k / 2).size() % 2 == 1) {
            return false;
        }
        return modToIndex.get(0).size() % 2 != 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canArrange(new int[] {-1, 1, -2, 2, -3, 3, -4, 4}, 3));
    }
}