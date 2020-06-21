package util;

public class Parser {
    // 数组转二叉树
    // Parser.fromArrayToBinaryTree(new Integer[]{-10,9,20,null,null,15,7});
    public static TreeNode fromArrayToBinaryTree(Integer[] array) {

        if (array.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(array[0]);

        build(head, array, 0);

        return head;
    }

    private static void build(TreeNode node, Integer[] array, int index) {
        if (index * 2 + 1 < array.length && array[index * 2 + 1] != null) {
            node.left = new TreeNode(array[2 * index + 1]);
            build(node.left, array, 2 * index + 1);
        }
        if (index * 2 + 2 < array.length && array[index * 2 + 2] != null) {
            node.right = new TreeNode(array[2 * index + 2]);
            build(node.right, array, 2 * index + 2);
        }
    }
}
