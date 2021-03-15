package leetcode.offer;


public class Offer15 {
    public static void main(String[] args) {
        Offer15 o = new Offer15();
        o.hammingWeight(0b11111111111111111111111111111101);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {


        int res = 0;
        if (n < 0) res++;

        int temp = 1;
        for (int i = 0; i < 31; i++) {
            if ((n & temp) > 0) res++;
            temp = temp << 1;
        }


        return res;
    }

}
