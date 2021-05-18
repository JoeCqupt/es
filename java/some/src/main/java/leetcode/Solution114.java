package leetcode;

public class Solution114 {


    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        if(root.left == null){
            return;
        }

        if(root.right!=null){
            TreeNode   temp = root.left;
            while (temp.right!=null){
                temp = temp.right;
            }
            temp.right = root.right;
        }
        root.right = root.left;
        root.left = null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
