package kickstart.round2020.C.countdown;

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
        int n = scanner.nextInt(), k = scanner.nextInt();
        int cnt = 0;
        int tmp = k;

        for (int i = 0; i < n; i++) {
            int now = scanner.nextInt();
            if (now == tmp && tmp > 0) {
                tmp--;
            } else if (tmp != 0){
                tmp = k;
                if (now == tmp) {
                    tmp--;
                }
            }
            if (tmp == 0) {
                cnt++;
                tmp = k;
            }
        }
        return cnt;
    }
}
