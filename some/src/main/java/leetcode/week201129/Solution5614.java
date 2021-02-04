package leetcode.week201129;


import java.util.*;

/**
 *
 */
public class Solution5614 {
    public static void main(String[] args) {
        Solution5614 solution5614 = new Solution5614();
        int[] result = solution5614.mostCompetitive(
                new int[]{7, 8, 9, 2, 1, 3},
                4
        );

        System.out.println(Arrays.toString(result));
    }


    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        int m = n - k;// 移除m个元素就行了
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!q.isEmpty() && m > 0 && q.peekLast() > num) {
                q.pollLast();
                m--;
                if(m==0){
                    break;
                }
            }
            q.addLast(num);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = q.pollFirst();
        }
        return result;
    }

}
