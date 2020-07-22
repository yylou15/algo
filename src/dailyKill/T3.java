package dailyKill;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String vs = scanner.nextLine();
        String[] tmp = vs.split(" ");
        int[][] grid = new int[tmp.length][3];
        for (int i = 0; i < tmp.length; i++) {
            String v = tmp[i];
            String[] info = v.split(",");
            grid[i] = new int[]{
                Integer.parseInt(info[0]),Integer.parseInt(info[1]),Integer.parseInt(info[2])
            };
        }

        int beginCity = scanner.nextInt();
        int endCity = scanner.nextInt();
        int maxSteps = scanner.nextInt();
        System.out.println(f(n,grid,beginCity,endCity,maxSteps));
    }


    public static int f(int n, int[][] grid, int src, int dst, int K) {
        int[][] dist = new int[2][n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = dist[1][src] = 0;

        for (int i = 0; i <= K; ++i)
            for (int[] edge: grid)
                dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], dist[~i&1][edge[0]] + edge[2]);

        return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
    }
}
