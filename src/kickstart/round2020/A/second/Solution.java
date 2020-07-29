package kickstart.round2020.A.second;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int kase = 1; kase <= T; kase++) {
            int n = scanner.nextInt(), k = scanner.nextInt(), p = scanner.nextInt();
            int[][] plates = new int[n][k];
            int[][] sum = new int[n][p];
            int[][] dp = new int[n][p];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    plates[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                sum[i][0] = plates[i][0];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < p; j++) {
                    if (j >= k) {
                        sum[i][j] = sum[i][j - 1];
                    } else { sum[i][j] = sum[i][j - 1] + plates[i][j]; }
                }
            }
            for (int j = 0; j < p; j++) {
                dp[0][j] = sum[0][j];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < p; j++) {
                    int mx = Integer.MIN_VALUE;
                    for (int l = j; l >= 0; l--) {
                        if (j - l - 1 < 0) {
                            mx = Math.max(mx, dp[i - 1][l]);
                        } else {
                            mx = Math.max(mx, dp[i - 1][l] + sum[i][j - l - 1]);
                        }
                    }
                    dp[i][j] = mx;
                }
            }
            System.out.println(String.format("Case #%s: %s", kase, dp[n - 1][p - 1]));
        }
    }
}
