package leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer value : list) {
            res[index++] = value;
        }
        return res;
    }
}
