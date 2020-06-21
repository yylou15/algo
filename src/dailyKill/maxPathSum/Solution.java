package dailyKill.maxPathSum;

import util.Parser;
import util.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode node) {
        int lSum = 0, rSum = 0;
        if (node.left != null) {
            lSum = Math.max(dfs(node.left), 0);
        }
        if (node.right != null) {
            rSum = Math.max(dfs(node.right), 0);
        }
        this.sum = Math.max(this.sum, node.val + lSum + rSum);
        return node.val + Math.max(lSum, rSum);
    }

    public static void main(String[] args) {
        int sum = new Solution().maxPathSum(Parser.fromArrayToBinaryTree(new Integer[]{2, -1}));
        System.out.println(sum);
    }
}
