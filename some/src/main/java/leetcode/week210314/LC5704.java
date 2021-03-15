package leetcode.week210314;

/**
 *  算法超时
 */
public class LC5704 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];

        int min = Integer.MAX_VALUE;
        // 计算前缀的最小值
        for (int j = k; j >= 0; j--) {
            min = Math.min(min, nums[j]);
            temp[j] = min;
        }
        min = Integer.MAX_VALUE;
        for (int j = k; j < n; j++) {
            min = Math.min(min, nums[j]);
            temp[j] = min;
        }
        int res = 0;
        for (int i = k; i < n; i++) {
            for (int j = k; j >= 0; j--) {
                int tempMin = Math.min(temp[i], temp[j]);
                if(tempMin*(i-0+1)<=res){
                    break;
                }
                res = Math.max(res, tempMin * (i - j + 1));
            }
        }
        return res;
    }
}
