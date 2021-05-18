package leetcode;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        String res = solution.longestPalindrome("cbbd");
        System.out.println(res);
    }
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        boolean[][] dp = new boolean[length][length];

        // 初始化
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        int resStart = 0;

        for (int i = 2; i <= length; i++) {
            for (int j = 0; j < length; j++) {
                int end = j + i - 1;
                if (end >= length) {
                    break;
                } else if (
                        (s.charAt(j) == s.charAt(end) && dp[j + 1][end - 1])
                                ||
                                (i == 2 && s.charAt(j) == s.charAt(end))
                ) {
                    dp[j][end] = true;

                    if (i > maxLength) {
                        maxLength = i;
                        resStart = j;
                    }
                } else {
                    dp[j][end] = false;
                }
            }
        }

        return s.substring(resStart, resStart+maxLength);
    }

}
