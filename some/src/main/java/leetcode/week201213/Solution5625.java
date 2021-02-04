package leetcode.week201213;

public class Solution5625 {

    public static void main(String[] args) {
        Solution5625 solution5625 = new Solution5625();
        int i = solution5625.numberOfMatches(3);
        System.out.println(i);
    }
    public int numberOfMatches(int n) {
        int result = 0;
        if (n < 2) {
            return result;
        }
        while (true) {
            int i = n / 2;
            int j = n % 2;
            if ((i + j) != 0) {
                result += i;
                n = i + j;
                if(i==1 && j ==0){
                    break;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
