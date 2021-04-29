package leetcode.offer;

public class Offer28 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean c1 = isSymmetric(left.left, right.right);
        boolean c2 = false;
        if (c1)
            c2 = isSymmetric(left.right, right.left);

        return c1 && c2;
    }

}
