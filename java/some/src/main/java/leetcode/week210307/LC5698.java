package leetcode.week210307;

import java.util.Arrays;

public class LC5698 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum=0L;
        for(int num: nums){
            sum+=num;
        }
        if (sum == goal) return 0;
        long dep = goal - sum;
        return (int) (Math.abs(dep / limit) + (dep%limit==0?0:1));
    }

}
