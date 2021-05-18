package leetcode.offer;

public class Offer24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode pos = head;
        while (pos != null) {
            ListNode temp = pos;
            pos = pos.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

}
