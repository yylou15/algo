package kickstart.round2020.C.stablewall;

import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int kase = 1; kase <= T; kase++) {
            System.out.println(String.format("Case #%s: %s", kase, solve()));
        }
    }

    private static Object solve() {
        int n = 100000;
        int[] nums = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 100;
        }

        //sum[0][0] = nums[0];
        //for (int j = 1; j < n; j++) {
        //    sum[0][j] = sum[0][j - 1] + nums[j];
        //}
        //for (int i = 1; i < n; i++) {
        //    for (int j = i; j < n; j++) {
        //        sum[i][j] = sum[i - 1][j] - nums[i - 1];
        //    }
        //}

        dp[0] = isSquare(nums[0]) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            int tmpSum = 0;
            for (int j = i; j >= 0; j--) {
                tmpSum += nums[j];
                if (isSquare(tmpSum)) {
                    cnt++;
                }
            }
            dp[i] = dp[i - 1] + cnt;
        }

        return dp[n - 1];
    }

    private static boolean isSquare(int num) {
        if (num < 0) {
            return false;
        }
        return Math.abs(Math.sqrt(num) % 1) < 0.0001;
    }
}
