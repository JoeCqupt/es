package leetcode;

/**
 * 思想是：快慢指针
 */
public class Solution19_2 {
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
        ListNode slow = head;
        ListNode fast = head;
        // 走了n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while (fast != null && fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
