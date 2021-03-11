package leetcode.offer;

public class Offer06 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int size;
    int totalSize;
    int res[];

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            totalSize = size;
            res = new int[size];
            return res;
        }
        size++;
        int[] ints = reversePrint(head.next);
        ints[totalSize-size] = head.val;
        size--;
        return ints;
    }
}
