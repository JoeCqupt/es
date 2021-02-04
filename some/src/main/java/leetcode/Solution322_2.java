package leetcode;


public class Solution322_2 {
    public int coinChange(int[] coins, int amount) {
        int[] dpTable = new int[amount + 1];
        //初始化dpTable
        for (int i = 0; i < dpTable.length; i++) {
            // 因为结果最大值不过也就amount
            dpTable[i] = amount + 1;
        }

        dpTable[0] = 0;
        for (int i = 1; i < dpTable.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;

                dpTable[i] = Math.min(dpTable[i], dpTable[i - coin] + 1);
            }
        }
        return dpTable[amount] == amount + 1 ? -1 : dpTable[amount];
    }
}
