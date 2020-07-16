package dailyKill.isBipartite;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> eStatus = new HashMap<>();
        eStatus.put(1, 1);
        for (int i = 2; i <= 100; i++) {
            eStatus.put(i, 0);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] > i) {
                    Integer status1 = eStatus.get(i);
                    if (eStatus.get(graph[i][j]) != 0) {
                        if (eStatus.get(graph[i][j]).equals(status1)) {
                            return false;
                        }
                    } else {
                        eStatus.put(graph[i][j], status1.equals(1) ? 2 : 1);
                    }
                }
            }
        }
        return true;
    }
}
