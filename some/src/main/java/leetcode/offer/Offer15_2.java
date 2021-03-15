package leetcode.offer;

public class Offer15_2 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1>>31));  // 右移左边补符号位    带符号右移动
        System.out.println(Integer.toBinaryString(-1>>>31)); // 右移左边补0        无符号右移动

    }


    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

}
