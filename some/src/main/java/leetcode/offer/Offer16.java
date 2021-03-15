package leetcode.offer;

/**
 *  超时： todo joe  待优化
 */
public class Offer16 {
    public static void main(String[] args) {
        Offer16 o = new Offer16();
        double v = o.myPow(2.0, -2);
        System.out.println(v);
    }
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n<0) {
            x = 1/x;
            n = 0-n;
        }

        double res = 1;
        for(int i = 1; i<=n; i++)
            res *= x;
        return res;
    }
}
