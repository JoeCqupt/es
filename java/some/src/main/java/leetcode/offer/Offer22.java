package leetcode.offer;

public class Offer22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = null;
        ListNode p = head;
        int count = 1;
        while (p != null) {
            if (count == k) pre = head;
            p = p.next;
            if (p == null) break;
            if (pre != null) pre = pre.next;
            count++;
        }
        return pre;
    }

}
