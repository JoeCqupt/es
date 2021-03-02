package leetcode.middle.s3_tree;

public class LC230_2 {
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


    public int kthSmallest(TreeNode node, int k) {
        // 使用迭代的方式实现一次 todo joe

        // 进阶问题：记忆化BST实现
        return -1;
    }
}
