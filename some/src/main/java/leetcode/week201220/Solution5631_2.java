package leetcode.week201220;

public class Solution5631_2 {

    public static void main(String[] args) {
        Solution5631_2 solution5631 = new Solution5631_2();
        int result = solution5631.maxResult(
                new int[]{
                        1, -1, -2, 4, -7, 3
                },
                2
        );
        System.out.println(result);
    }


    public int maxResult(int[] nums, int k) {
        int[] dpTable = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dpTable[i] = nums[0];
                max = dpTable[0];
                continue;
            }

            // 求max
            if(i<=k){
                max = Math.max(max, dpTable[i-1]);
            }else {
                if (dpTable[i-k-1] == max){
                    max = dpTable[i-1];
                    // 重新找
                    for (int m = i - 1; m >= i - k; m--) {
                        max = Math.max(max, dpTable[m]);
                    }
                }else {
                    max = Math.max(dpTable[i-1], max);
                }
            }

            dpTable[i] = max + nums[i];

        }
        return dpTable[nums.length - 1];
    }

}
