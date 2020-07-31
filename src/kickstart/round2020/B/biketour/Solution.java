package kickstart.round2020.B.biketour;

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
        int[] peek = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            peek[i] = scanner.nextInt();
        }
        for (int i = 1; i < n - 1; i++) {
            if (peek[i] > peek[i-1] && peek[i] > peek[i+1]){
                cnt++;
            }
        }
        return cnt;
    }
}
