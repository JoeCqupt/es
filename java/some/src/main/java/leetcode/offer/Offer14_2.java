package leetcode.offer;

public class Offer14_2 {

    int DIV = 1000000007;


    public int cuttingRope(int n) {
        if (n<4) return n-1;
        long res = 1;
        while (n>4){
            res *= 3;
            res = res%DIV;
            n = n-3;
        }
        return (int) (n*res)%DIV;
    }
}
