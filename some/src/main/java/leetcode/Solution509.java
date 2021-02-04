package leetcode;

public class Solution509 {

    public int fib(int n) {
        int[] dpTable = new int[2];
        if (n < 2) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                dpTable[i] = i;
            } else {
                dpTable[i % 2] = dpTable[0] + dpTable[1];
            }
        }
        return dpTable[0] + dpTable[1];

    }

}
