package leetcode.week210321;

public class Solution5709 {

    public static void main(String[] args) {
        Solution5709 s= new Solution5709();
        int i = s.maxAscendingSum(new int[]{10, 20, 30, 40, 50});
        System.out.println(i);
    }

    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            int value = nums[i];
            if (value > pre) {
                sum += value;
            } else {
                res = Math.max(sum, res);
                sum = value;
            }
        }
        res = Math.max(sum, res);

        return res;
    }

}
