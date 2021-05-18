package leetcode;

public class Solution19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode current = head;
        int value = remove(current, n);
        if (value == n + 1) {
            return head.next;
        }
        return head;
    }

    private int remove(ListNode current, int n) {
        if (current == null) {
            return 1;
        }
        int value = remove(current.next, n);

        if (value == (n + 1)) {
            current.next = current.next.next;
        }
        return ++value;
    }
}
