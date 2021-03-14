package leetcode.offer;

public class Offer10 {

    int DIV = 1000000007;

    public int fib(int n) {
        int n1 = 0;
        int n2 = 1;
        if (n == 0) return n1;
        if (n == 1) return n2;
        for (int i = 2; i <= n; i++) {
            int temp = n2;
            n2 = (n1 + n2) % DIV ;
            n1 = temp % DIV;
        }
        return n2 ;
    }

}
