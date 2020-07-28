package dailyKill.maxDepth;

import util.Parser;
import util.TreeNode;

public class Solution {
    int max = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) {
            return;
        } else {
            max = Math.max(max, deep);
            dfs(node.left, deep + 1);
            dfs(node.right, deep + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth(Parser.fromArrayToBinaryTree(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }
}