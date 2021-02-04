package leetcode;

import java.util.*;

public class Solution1497 {
    /**
     * error : 没有考虑 负数的情况
     *
     * @param arr
     * @param k
     * @return
     */
    public boolean canArrange(int[] arr, int k) {
        int match = 0;
        Map<PointNum, Integer> map = new HashMap<>();
        List<PointNum> lookFors = new ArrayList<>(2);
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            int div = v % k;
            lookFors.clear();
            if (div != 0) {
                if (div > 0) {
                    lookFors.add(new PointNum(k - div, k));
                } else {
                    lookFors.add(new PointNum(-k - div, k));
                }
                lookFors.add(new PointNum(-div, k));
            } else {
                lookFors.add(new PointNum(div, k));
            }

            boolean find = false;
            for (PointNum lookFor : lookFors) {
                Integer times = map.get(lookFor);
                if (times != null) {
                    if (times == 1) {
                        map.remove(lookFor);
                    } else {
                        map.put(lookFor, times - 1);
                    }
                    match++;
                    find = true;
                    break; //
                }
            }

            if(!find) {
                PointNum p = new PointNum(div, k);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
        }
        return match == arr.length / 2;
    }

    static class PointNum {
        int top;
        int down;

        public PointNum(int top, int down) {
            this.top = top;
            this.down = down;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointNum pointNum = (PointNum) o;
            return top == pointNum.top &&
                    down == pointNum.down;
        }

        @Override
        public int hashCode() {
            return Objects.hash(top, down);
        }
    }
}
