package dailyKill.largestValues;

import util.Parser;
import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> deepMxMap = new HashMap<>();
    int mxDeep = 0;

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, 1);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < mxDeep; i++) {
            ret.add(deepMxMap.get(i + 1));
        }
        return ret;
    }

    private void dfs(TreeNode node, int deep) {
        this.mxDeep = Math.max(this.mxDeep, deep);

        deepMxMap.merge(deep, node.val, Math::max);

        if (node.left != null)
            dfs(node.left, deep + 1);
        if (node.right != null)
            dfs(node.right, deep + 1);
    }

    public static void main(String[] args) {
        new Solution().largestValues(Parser.fromArrayToBinaryTree(new Integer[]{1, 3, 2, 5, 3, 9}));
    }
}
