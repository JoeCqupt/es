package leetcode.primary.s4_tree;

public class LC108 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return  null;  // todo jiangyuan
    }

    public static class TreeNode {
        int val;
        LC101.TreeNode left;
        LC101.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, LC101.TreeNode left, LC101.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}