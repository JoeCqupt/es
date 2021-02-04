package leetcode;

public class Solution114_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        doFlatten(root, false);
    }

    private TreeNode doFlatten(TreeNode root, boolean isLeft) {
        if (root == null) {
            return null;
        }

        TreeNode temp = doFlatten(root.left, true);
        doFlatten(root.right, false);

        if (root.left == null) {
            if (isLeft) {
                TreeNode tempTail = root;
                while (tempTail.right != null) {
                    tempTail = tempTail.right;
                }
                return tempTail;
            }
            return null;
        }

        if (root.right != null) {
            temp.right = root.right;
        }
        root.right = root.left;
        root.left = null;
        if (isLeft) {
            TreeNode tempTail2 = temp;
            while (tempTail2.right != null) {
                tempTail2 = tempTail2.right;
            }
            return tempTail2;
        }
        return null;
    }

}
