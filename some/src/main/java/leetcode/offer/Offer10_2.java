package leetcode.offer;

public class Offer10_2 {
    int DIV = 1000000007;

    public int numWays(int n) {
        int n1 = 1;
        int n2 = 2;
        if (n == 0) return n1;
        if (n == 1) return n1;
        if (n == 2) return n2;
        for (int i = 3; i <= n; i++) {
            int temp = n2;
            n2 = (n2 + n1) % DIV;
            n1 = temp;
        }
        return n2;
    }

}
