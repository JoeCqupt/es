package leetcode;

import java.util.LinkedList;

/**
 * 很简单的BFS / DFS 题目，但是我还是提交错误了几次，细节考虑不怎么周到
 */
public class Solution111 {
    public class TreeNode {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deep = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                deep++;
                queue.add(null);
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);

            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (node.left == null && node.right == null) {
                return deep;
            }
        }
        return deep;
    }
}
