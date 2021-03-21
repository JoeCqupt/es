package leetcode;


public class Solution206 {


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }


        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode tmp1 = next;
            ListNode tmp2 = pre;
            pre = next;
            next = next.next;

            tmp1.next = tmp2;
            if (tmp2 == head) {
                tmp2.next = null;
            }
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head5.next = null;
        new Solution206().reverseList(head);
    }
}