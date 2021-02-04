package leetcode.week210110;

import java.util.Arrays;

public class Solution5649 {

    public static void main(String[] args) {
        Solution5649 solution = new Solution5649();
        System.out.println(Arrays.toString(
                solution.decode(
                        new  int[]{6,2,7,3},
                        4
                ))
        );
    }

    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            int en = encoded[i];
            int temp = ((en | first) - first) + (~en & first);
            res[i + 1] =temp;
            first = temp;
        }
        return res;
    }

}
