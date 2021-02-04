package leetcode;

public class Solution92 {
    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode subHead = null;
        ListNode subPre = null;

        ListNode preNode = null;

        ListNode pos = head;
        for (int i = 1; pos != null; i++) {
            // 下一个节点
            ListNode next = pos.next;

            if (i == m) {
                subHead = pos;
                subPre = preNode;
            }
            if (i > m && i < n) {
                pos.next = preNode;
            }
            if (i == n) {
                ListNode subNext = pos.next ;
                pos.next = preNode;

                subHead.next = subNext;
                if (subPre != null) {
                    subPre.next = pos;
                }else {
                    head = pos;
                }
                break;
            }

            preNode = pos;
            pos = next;
        }

        return head;
    }

}

