package leetcode.middle.s3_tree;

/**
 *  解题思路：充分利用上层建立好的next链表
 */
public class LC116_2 {

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
        Node mostLeft = root;
        while (mostLeft!=null){
            if(mostLeft.left==null){
                break;
            }
            Node p = mostLeft;
            while (p!=null){
                p.left.next = p.right;
                if(p.next!=null){
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            mostLeft = mostLeft.left;
        }

        return root;
    }
}
