package leetcode.offer;

public class Offer36 {

    static
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.left = node1;
        node2.right = node3;

        Offer36 offer36 = new Offer36();
        Node node = offer36.treeToDoublyList(node2);
        System.out.println(node);
    }


    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node[] nodes = convertTree(root);
        Node head = nodes[0];
        Node tail = nodes[1];
        head.left = tail;
        tail.right = head;
        return head;
    }

    /**
     * @param node current node
     * @return part of list, pos 0: head  pos1:  tail
     *
     * 有点性能问题就是每次返回需要new一个数组
     */
    private Node[] convertTree(Node node) {
        if (node == null) return null;
        Node leftList[] = convertTree(node.left);
        if (leftList != null) {
            leftList[1].right = node;
            node.left = leftList[1];
        }

        Node rightList[] = convertTree(node.right);
        if (rightList != null) {
            rightList[0].left = node;
            node.right= rightList[0];
        }

        if (leftList == null && rightList == null) {
            return new Node[]{node, node};
        } else if (leftList == null) {
            return new Node[]{node, rightList[1]};
        } else if (rightList == null) {
            return new Node[]{leftList[0], node};
        } else {
            return new Node[]{leftList[0], rightList[1]};
        }
    }
}
