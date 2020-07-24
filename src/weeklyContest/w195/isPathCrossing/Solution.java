package weeklyContest.w195.isPathCrossing;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class Solution {
    public boolean isPathCrossing(String path) {
        if ("".equals(path) || path == null){
            return false;
        }
        Set<Pair<Integer, Integer>> dots = new HashSet<>();
        int x = 0, y = 0;
        dots.add(new Pair<>(x, y));
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    break;
            }
            if (dots.contains(new Pair<>(x, y))) {
                return true;
            } else {
                dots.add(new Pair<>(x, y));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().isPathCrossing("NESWW");
    }
}