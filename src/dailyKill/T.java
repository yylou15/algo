package dailyKill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int[] trace1 = new int[n1];
        int[] trace2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            trace1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            trace2[i] = scanner.nextInt();
        }

        Arrays.sort(trace1);
        Arrays.sort(trace2);

        if (trace1[0] > trace2[0] && trace1[trace1.length - 1] > trace2[trace2.length - 1]){
            
        }

    }
}
