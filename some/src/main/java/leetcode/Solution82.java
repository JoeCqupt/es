package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution82 {
    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-oayn/

    /**
     * 美团二面 遇到的面试题
     */


    public class ListNode {
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


    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        ListNode pos = head;
        while (pos != null) {
            cntMap.put(pos.val, cntMap.getOrDefault(pos.val, 0) + 1);
            pos = pos.next;
        }
        while (head != null && cntMap.get(head.val) > 1) {
            head = head.next;
        }
        if (head == null) return null;

        ListNode pre = head;
        pos = head.next;
        while (pos != null) {
            if(cntMap.get(pos.val)>2){
                pre.next = pos.next;
            }else {
                pre = pos;
            }
            pos = pos.next;
        }
        return head;
    }
}
