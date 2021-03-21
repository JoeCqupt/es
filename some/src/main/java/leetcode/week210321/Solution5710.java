package leetcode.week210321;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5710 {

    public static void main(String[] args) {
        Solution5710 s = new Solution5710();
        int numberOfBacklogOrders = s.getNumberOfBacklogOrders(
                new int[][]
                        {{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}
        );
        System.out.println(numberOfBacklogOrders);
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? -1 : 1;
            }
        });

        PriorityQueue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < orders.length; i++) {
            int[] temp = orders[i];
            if (temp[2] == 0) {
                // buy
                while (!sell.isEmpty()) {
                    int[] peek = sell.peek();
                    if (peek[0] > temp[0]) {
                        break;
                    } else {
                        if (peek[1] <= temp[1]) {
                            sell.poll();
                            temp[1] -= peek[1];
                            if (temp[1] == 0) {
                                break;
                            }
                        } else {
                            peek[1] -= temp[1];
                            temp[1] = 0;
                            break;
                        }
                    }
                }
                if (temp[1] > 0)
                    buy.offer(temp);
            } else {
                // sell
                while (!buy.isEmpty()) {
                    int[] peek = buy.peek();
                    if (peek[0] < temp[0]) {
                        break;
                    } else {
                        if (peek[1] <= temp[1]) {
                            buy.poll();
                            temp[1] -= peek[1];
                            if (temp[1] == 0) {
                                break;
                            }
                        } else {
                            peek[1] -= temp[1];
                            temp[1] = 0;
                            break;
                        }
                    }
                }
                if (temp[1] > 0)
                    sell.offer(temp);
            }
        }
        int res = 0;
        int DIV = 1000000007;
        while (!sell.isEmpty()) {
            res += sell.poll()[1] % DIV;
            res = res %DIV;
        }
        while (!buy.isEmpty()) {
            res += buy.poll()[1] % DIV;
            res = res %DIV;
        }
        return res;
    }

}
