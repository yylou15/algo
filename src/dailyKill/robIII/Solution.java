package dailyKill.robIII;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

class Solution {
    private Map<TreeNode, Integer> DP = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.val;
        }

        int param1 = node.val;
        if (node.left != null) {
            param1 += dfs(node.left.left);
            param1 += dfs(node.left.right);
        }
        if (node.right != null) {
            param1 += dfs(node.right.left);
            param1 += dfs(node.right.right);
        }

        int res = Math.max(param1, dfs(node.left) + dfs(node.right));
        DP.put(node, res);
        return res;

    }

    public static void main(String[] args) {

    }
}
