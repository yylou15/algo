package kickstart.round2020.A.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int kase = 1; kase <= T; kase++) {
            int n = scanner.nextInt();
            int budget = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Arrays.sort(cost);
            int sum = 0, i = 0;
            for (; i < n; i++) {
                if (sum + cost[i] > budget) {
                    break;
                } else {
                    sum += cost[i];
                }
            }
            System.out.println(String.format("Case #%s: %s", kase, i));
        }
    }
}