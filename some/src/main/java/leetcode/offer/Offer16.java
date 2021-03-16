package leetcode.offer;


public class Offer16 {
    public static void main(String[] args) {
        Offer16 o = new Offer16();
        double v = o.myPow(2.0, 10);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // 不能使用这个思路
//        if(n<0) {
//            x = 1/x;
//            n = 0-n; //有溢出风险: n取值：Integer.MIN_VALUE
//        }

        /**
         * 思路：
         * n为奇数： x^n = x * x^n-1
         * n为偶数  x^n = x^2 ^ n/2
         */
        double res = 1;
        while (Math.abs(n / 2) > 0) {
            if (n % 2 != 0) {
                res *= n < 0 ? 1 / x : x;
            }
            x = x * x;
            n = n / 2;
        }
        return n == 1 ? x * res : (1 / x) * res;
    }
}
