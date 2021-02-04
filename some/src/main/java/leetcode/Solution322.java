package leetcode;

import java.util.HashMap;

public class Solution322 {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        Integer cacheValue = cache.get(amount);
        if (cacheValue != null) {
            return cacheValue;
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int result = -1;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin);
            if (res == -1) continue;

            if (result != -1) {
                result = Math.min(res + 1, result);
            } else {
                result = res + 1;
            }

        }
        cache.put(amount, result);
        return result;
    }

}
