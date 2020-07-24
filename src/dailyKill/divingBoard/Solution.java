package dailyKill.divingBoard;

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k==0){
            return new int[0];
        }
        if (shorter == longer){
            return new int[]{shorter * k};
        }
        int[] ret = new int[k + 1];
        int gap = longer - shorter;
        for (int i = 0; i < k + 1; i++) {
            ret[i] = shorter * k + i * gap;
        }
        return ret;
    }
}
