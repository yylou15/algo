package kickstart.round2020.A.forth;

import java.util.Scanner;

public class Soltuion {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int kase = 1; kase <= T; kase++) {
            System.out.println(String.format("Case #%s: %s", kase, solve()));
        }
    }

    private static Object solve() {
        int n = scanner.nextInt();
        return 0;
    }
}
