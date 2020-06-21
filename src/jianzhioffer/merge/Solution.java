package jianzhioffer.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ret = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            int step = 1;
            while (i + step < intervals.length &&
                    (intervals[i + step][0] <= intervals[i + step - 1][1] + 1)) {
                end = Math.max(end, intervals[i + step][1]);
                begin = Math.min(begin, intervals[i + step][0]);
                step++;
            }
            ret.add(new int[]{begin, end});
            i += step;
        }
        int[][] ret1 = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++) {
            ret1[i] = ret.get(i);
        }
        return ret1;
    }

    public static void main(String[] args) {
//        new Solution().merge(new int[][]{
//                {1, 3}, {2, 6}, {8, 10}, {15, 18}
//        });
        new Solution().merge(new int[][]{
                {1, 4}, {4, 5}
        });
    }
}
