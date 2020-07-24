package dailyKill.hasPathSum;

import util.TreeNode;

public class Solution {
    boolean ans = false;
    int sum;
    int tmp = 0;

    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root);
        return this.ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        this.tmp += node.val;
        if (node.left == null && node.right == null && this.tmp == this.sum){
            this.ans = true;
        }
        if (node.left != null){
            dfs(node.left);
        }
        if (node.right != null){
            dfs(node.right);
        }
        this.tmp -= node.val;
    }
}
