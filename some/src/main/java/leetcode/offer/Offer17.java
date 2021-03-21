package leetcode.offer;

import java.util.Arrays;

public class Offer17 {
    public static void main(String[] args) {
        Offer17 o = new Offer17();
        int[] ints = o.printNumbers(3);
        System.out.println(Arrays.toString(ints));
    }
    public int[] printNumbers(int n) {
        int end = 1;
        for (int i = 1; i <= n; i++)
            end *= 10;
        int[] res = new int[end - 1];
        for (int i = 1; i < end; i++) {
            res[i - 1] = i;
        }

        return res;
    }
}
