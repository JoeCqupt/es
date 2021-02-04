package leetcode;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution322_3 {
    public static void main(String[] args) {
        Solution322_3 solution = new Solution322_3();
        int res = solution.coinChange(
                new int[]{1, 2147483647},
                2
        );

        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dpTable = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int value = i - coin;
                if (value == 0) {
                    dpTable[i] = 1;
                    break;
                } else if (value > 0) {
                    if (dpTable[value] == 0) {
                        continue;
                    }
                    if (dpTable[i] > 0) {
                        dpTable[i] = Math.min(dpTable[value] + 1, dpTable[i]);
                    } else {
                        dpTable[i] = dpTable[value] + 1;
                    }
                }
            }
        }

        return dpTable[amount] == 0 ? -1 : dpTable[amount];
    }
}
