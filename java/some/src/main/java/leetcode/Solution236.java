package leetcode;

public class Solution236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return res;
    }

    private int search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int left = search(root.left, p, q);
        if (left == 2) return 2;
        int right = search(root.right, p, q);
        if (right == 2) return 2;

        if (left == 1 && right == 1 && res == null) {
            res = root;
            return 2;
        } else if ((left == 1 || right == 1) && (root.val == p.val || root.val == q.val)) {
            res = root;
            return 2;
        } else if (root.val == p.val || root.val == q.val) {
            return left + right + 1;
        } else {
            return left + right;
        }
    }

}
