package leetcode.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Offer45 {

    public static void main(String[] args) {
        Offer45 offer = new Offer45();
        int i = offer.spCompare(3, 30);
        System.out.println(i);
    }

    public String minNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        int idx = 0;
        for (int n : nums) {
            arr[idx++] = n;
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return spCompare(o1, o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n);
        }
        return sb.toString();
    }

    public int spCompare(int a, int b) {
        List<Integer> aNums = new ArrayList<>();
        List<Integer> bNums = new ArrayList<>();
        while (a / 10 > 0) {
            int last = a % 10;
            aNums.add(last);
            a = a / 10;
        }
        aNums.add(a);

        while (b / 10 > 0) {
            int last = b % 10;
            bNums.add(last);
            b = b / 10;
        }
        bNums.add(b);

//        System.out.println(aNums);
//        System.out.println(bNums);

        int aIdx = aNums.size() - 1;
        int bIdx = bNums.size() - 1;
        while (aIdx >= 0 || bIdx >= 0) {
            if (aIdx < 0) aIdx = aNums.size() - 1;
            if (bIdx < 0) bIdx = bNums.size() - 1;

            int an = aNums.get(aIdx);
            int bn = bNums.get(bIdx);
            if (an == bn) {
                aIdx--;
                bIdx--;
            } else if (an > bn) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

}
