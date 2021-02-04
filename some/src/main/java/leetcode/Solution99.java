package leetcode;

public class Solution99 {
    TreeNode node1, node2;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        recoverInOrder(root);
        int temp;
        temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void recoverInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        recoverInOrder(node.left);
        if (prev != null && prev.val > node.val) {
            if (node1 == null) {
                node1 = prev;
            }
            // 这里千万不要写else： 有一种情况是被交换的点在最后一个
            node2 = node;
        }
        prev = node;
        recoverInOrder(node.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
