package leetcode.middle.s6_dp;

public class LC300 {
    public static void main(String[] args) {
        LC300 lc = new LC300();
        int i = lc.lengthOfLIS(new int[]{
                0,1,0,3,2,3
        });
        System.out.println(i);
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        int pre = nums[0];
        int res = 1;
        for (int i = 1; i < length; i++) {
            int value = nums[i];
            if (value > pre) {
                dp[i] = res + 1;
                pre = value;
                res = dp[i];
            } else if (pre == value) {
                dp[i] = res;
            } else {
                int tempDpValue = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (value > nums[j]) {
                        tempDpValue = Math.max(dp[j] + 1, tempDpValue);
                    }
                }
                if (tempDpValue >= res) {
                    pre = value;
                }
                dp[i] = tempDpValue;
                res = Math.max(tempDpValue, res);
            }
        }
        return res;
    }
}
