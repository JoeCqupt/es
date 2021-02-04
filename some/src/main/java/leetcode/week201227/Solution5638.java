package leetcode.week201227;

import java.util.PriorityQueue;

/**
 * 原本的思路就是使用有限队列，但是超时
 * <p>
 * 看题解大家都是用的有限队列，所以再有优先队列试试
 * // 通过，但是效率不算太高
 */
public class Solution5638 {
    public static void main(String[] args) {
        int[] apples = new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5
        };
        int[] days = new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};
        Solution5638 solution5638 = new Solution5638();
        int res = solution5638.eatenApples(apples, days);
        System.out.println(res);
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        int eaten = 0;
        for (int i = 0; ; i++) {
            if (i < apples.length) {
                if (apples[i] != 0) {
                    queue.add(new int[]{i + days[i], apples[i]});
                }
            } else if (queue.isEmpty()) {
                break;
            }
            while (!queue.isEmpty()) {
                if (queue.peek()[0] <= i || queue.peek()[1] == 0) {
                    queue.poll();
                } else {
                    break;
                }
            }
            if (!queue.isEmpty()) {
                queue.peek()[1]--;
                eaten++;
            }
        }
        return eaten;
    }
}
