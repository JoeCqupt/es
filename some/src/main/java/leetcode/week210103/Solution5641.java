package leetcode.week210103;

import java.util.Arrays;
import java.util.Comparator;

public class Solution5641 {

    public static void main(String[] args) {
        Solution5641 solution = new Solution5641();

       int res =  solution.maximumUnits(
                new int[][]{
                        {5,10},{2,5},{4,7},{3,9}
                },10
        );
        System.out.println(res);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int result = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int[] boxType = boxTypes[i];
            int nums = boxType[0];
            int size = boxType[1];
            if (truckSize <= nums) {
                result += (truckSize * size);
                break;
            } else {
                result += (nums * size);
                truckSize -= nums;
            }
        }
        return result;
    }

}
