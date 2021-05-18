package leetcode.week210411;

public class LC5726 {

    public int arraySign(int[] nums) {
        int lowerZero = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) lowerZero++;
        }
        return lowerZero % 2 == 0 ? 1 : -1;
    }

}
