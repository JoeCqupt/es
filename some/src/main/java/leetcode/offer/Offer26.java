package leetcode.offer;

public class Offer26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean res = false;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        preOrder(A, B);
        return res;
    }

    private void preOrder(TreeNode a, TreeNode b) {
        if (a == null) {
            return;
        }
        if (res) {
            return;
        }
        if (a.val == b.val) {
            if (compare(a, b)) {
                res = true;
                return;
            }
        }
        preOrder(a.left, b);
        preOrder(a.right, b);
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if (a != null && b == null) return true;
        if (a == null && b != null) return false;
        if (a == null && b == null) return true;
        if (a.val != b.val) {
            return false;
        }

        boolean l = compare(a.left, b.left);
        boolean r = compare(a.right, b.right);
        return l && r;
    }

}
