package leetcode;

import leetcode.common.ListNode;

public class Solution141 {
    /**
     * 快慢指针
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            ListNode temp1 = fast.next;
            if (temp1 == null) {
                break;
            } else {
                fast = fast.next.next;
            }
        }
        return false;
    }
}