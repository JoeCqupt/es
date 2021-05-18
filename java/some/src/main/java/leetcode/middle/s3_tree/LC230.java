package leetcode.middle.s3_tree;

public class LC230 {

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


    int counter = 0;
    public int kthSmallest(TreeNode node, int k) {
        if (node == null) {
            return -1;
        }
        int lr = kthSmallest(node.left, k);
        if (lr != -1) return lr;

        counter++;
        if (counter == k) return node.val;

        int rr = kthSmallest(node.right, k);
        return rr;
    }
}
