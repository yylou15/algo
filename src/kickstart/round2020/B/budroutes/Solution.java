package kickstart.round2020.B.budroutes;

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
        int n = scanner.nextInt();
        long ddl = scanner.nextLong();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextLong();
        }
        long[] actual = new long[n];
        actual[n - 1] = ddl - ddl % x[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            actual[i] = actual[i + 1] - actual[i + 1] % x[i];
        }
        return actual[0];
    }
}
