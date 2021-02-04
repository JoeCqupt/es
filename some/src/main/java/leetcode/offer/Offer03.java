package leetcode.offer;

public class Offer03 {

    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = nums[i];
            index = index>=n? index-n: index;
            int value = nums[index];
            if (value >= n) {
                return index;
            } else {
                nums[index] = value + n;
            }
        }
        return -1;
    }

}
