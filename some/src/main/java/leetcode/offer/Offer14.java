package leetcode.offer;

public class Offer14 {
    public static void main(String[] args) {
        Offer14 o = new Offer14();
        int i = o.cuttingRope(10);
        System.out.println(i);
    }


    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[1] = 1;
        for (int i = 3; i < n + 1; i++) {
            int res = 0;
            for(int j = 1; j<i;j++){
                int temp = Math.max(j*(i-j), j*dp[i-j]);
                res = Math.max(temp, res);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
