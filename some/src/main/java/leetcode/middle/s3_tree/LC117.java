package leetcode.middle.s3_tree;

public class LC117 {

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

    /**
     * 这个写法有点复杂，可以看一下官方题解，那个简单一点 // todo 尝试一下官方的题解的写法
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node mostLeft = root;
        while (mostLeft != null) {
            Node p = mostLeft;
            Node nextMostLeft = null;
            while (p != null) {
                if (p.left != null || p.right != null) {
                    Node need;
                    if (p.left != null && p.right != null) {
                        p.left.next = p.right;
                        if (nextMostLeft == null) nextMostLeft = p.left;
                        need = p.right;
                    } else {
                        need = p.left == null ? p.right : p.left;
                        if (nextMostLeft == null) nextMostLeft = need;
                    }
                    while (p.next != null) {
                        if (p.next.left != null || p.next.right != null) {
                            need.next = p.next.left != null ? p.next.left : p.next.right;
                            break;
                        }
                        p = p.next;
                    }

                }
                p = p.next;
            }
            mostLeft = nextMostLeft;
        }
        return root;
    }
}
