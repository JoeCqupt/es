package leetcode.offer;

public class Offer39 {

    public int majorityElement(int[] nums) {
        int most = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                most = nums[i];
                count++;
            } else if (nums[i] == most) {
                count++;
            } else {
                count--;
            }
        }
        return most;
    }
}
