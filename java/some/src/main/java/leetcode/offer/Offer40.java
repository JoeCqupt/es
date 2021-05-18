package leetcode.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[]{};
        if (k > arr.length) {
            Arrays.sort(arr);
            return arr;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (queue.size() < k) {
                queue.offer(temp);
            } else {
                if (temp < queue.peek()) {
                    queue.poll();
                    queue.offer(temp);
                }
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for(Integer i : queue){
            res[idx++] = i;
        }
        return res;
    }
}
