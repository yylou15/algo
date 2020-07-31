package kickstart.round2020.B.WanderingRobot;

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
        int w = scanner.nextInt(), h = scanner.nextInt(), l = scanner.nextInt(), u = scanner.nextInt(), r = scanner
            .nextInt(), d = scanner.nextInt();
        double p1 = 0, p2 = 0;
        if (u != 1) {
            if (r == w) {
                p1 = calcP(l, u - 1, w, h);
            } else {
                for (int i = l; i <= r; i++) {
                    double tmpP = calcP(i, u - 1, w, h);
                    p1 += tmpP * 1 / 2;
                }
            }
        }
        if (l != 1) {
            if (d == h) {
                p2 = calcP(l - 1, u, w, h);
            } else {
                for (int j = u; j <= d; j++) {
                    double tmpP = calcP(j, u - 1,w,h);
                    p2 += tmpP * 1 / 2;
                }
            }
        }
        return 1 - p1 - p2;
    }

    private static double calcP(int x, int y, int w, int h) {
        int steps = x + y - 2;
        double divide = Math.pow(2, steps);
        if (Math.min(w, h) < x + y - 1) {
            for (int i = Math.min(w, h); i < x + y - 1; i++) {
                divide -= C(steps, steps - i - 1);
            }
        }
        double p = C(steps, x - 1) / divide;
        return p;
    }

    public static int C(int n, int m) {
        m = Math.min(m, (n - m));
        int son = A(n, m);
        int mother = A(m, m);
        return son / mother;
    }

    public static int A(int n, int m) {
        int result = 1;
        for (int i = m; i > 0; i--) {
            result *= n;
            n--;
        }
        return result;
    }
}
