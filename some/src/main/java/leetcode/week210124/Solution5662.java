package leetcode.week210124;

public class Solution5662 {

    public static void main(String[] args) {
        Solution5662 sou = new Solution5662();
        int res = sou.minCharacters(
                "a",
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
        );
        System.out.println(res);
    }

    public int minCharacters(String a, String b) {
        int[] cntA = new int[26];
        int[] cntB = new int[26];


        for (char c : a.toCharArray()) {
            cntA[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            cntB[c - 'a']++;
        }

        int t1 = Integer.MAX_VALUE; // 情况一
        int t2 = Integer.MAX_VALUE; // 情况二
        int t3; // 情况三

        int max = 0;
        int la = a.length();
        int lb = b.length();
        for (int i = 0; i < 26; i++) {
           max =  Math.max(max, cntA[i] + cntB[i]);
           // 为什么小于25 ？？？？ @jiangyuan
           if(i<25) {
               if (i != 0) {
                   cntA[i] = cntA[i - 1] + cntA[i];
                   cntB[i] = cntB[i - 1] + cntB[i];
               }
               t1 = Math.min(t1, la - cntA[i] + cntB[i]);
               t2 = Math.min(t2, lb - cntB[i] + cntA[i]);
           }
        }
        t3 = la + lb - max;

        return Math.min(t1, Math.min(t2, t3));
    }
}
