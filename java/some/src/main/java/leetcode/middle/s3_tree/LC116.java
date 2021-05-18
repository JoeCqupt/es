package leetcode.middle.s3_tree;

import java.util.LinkedList;

/**
 * 比较笨的方法 空间复杂度O(n)
 */
public class LC116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        //比较笨一点的解法：二叉树的层序遍历
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node pre = null;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if(pre==null&&n==null){
                break;
            }
            if (pre == null) {
                pre = n;
            } else {
                pre.next = n;
                pre = n;
            }
            if (n != null) {
                queue.offer(n.left);
                queue.offer(n.right);
            } else {
                pre = null;
                queue.offer(null);
            }
        }
        return root;
    }
}
