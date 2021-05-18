package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node pos = head;

        Map<Node, Node> nodeMap = new HashMap<>();
        Node copyPre = null;
        Node copyHead = null;
        while (pos != null) {
            Node copy = new Node(pos.val);
            nodeMap.put(pos, copy);
            if (copyPre != null) copyPre.next = copy;
            copyPre = copy;
            if (pos == head) copyHead = copy;

            pos = pos.next;
        }

        pos = head;
        Node copyPos = copyHead;
        while (pos!=null){
            if(pos.random!=null)
                copyPos.random = nodeMap.get(pos.random);
            pos = pos.next;
            copyPos = copyPos.next;
        }


        return copyHead;
    }

}
