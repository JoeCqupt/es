package leetcode;

public class Solution142_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        if (node == null || node.next == null) {
            return null;
        }

        ListNode slow = node.next;
        ListNode fast = node.next.next;

        ListNode meet = null;

        while (slow != null && fast != null) {
            if (slow == fast) {
                meet = slow;
                break;
            } else {
                slow = slow.next;
                if (fast.next == null) break;
                fast = fast.next.next;
            }
        }

        if (meet == null) return null;

        while (node != meet) {
            node = node.next;
            meet = meet.next;
        }

        return meet;
    }

}
