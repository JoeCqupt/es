package leetcode.str;


import java.util.Arrays;

public class Kmp {


    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        String p = "aaaaaaabaaabaabac";
        String s = "ababcabaa";


        int[] next = kmp.getNext(s.toCharArray());
        System.out.println(Arrays.toString(next));
        next = kmp.getNext2(s.toCharArray());
        System.out.println(Arrays.toString(next));

        int i = 0;
        int j = 0;

        while (i < p.length() && j < s.length()) {
            if (p.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j - 1];
                if (j == 0) {
                    i++;
                }
            }
        }

        if (j == s.length()) {
            System.out.println(i - j);
        } else {
            System.out.println(-1);
        }
    }

    /**
     * 原来自己领悟的第一版是错误的，看完网上视频之后的修改版本
     *
     * @param s
     * @return
     */
    private int[] getNext(char[] s) {
        int[] result = new int[s.length];
        result[0] = 0;

        int j = 1;
        int len = 0;
        while (j < s.length) {
            if (s[len] == s[j]) {
                len++;
                result[j] = len;
                j++;

            } else {
                if (len > 0) {
                    len = result[len - 1];
                } else {
                    result[j] = 0;
                    j++;
                }
            }
        }
        return result;
    }


    /**
     * 优化版本: 处理  p:aaaaababa   s:aaaab
     *
     * @param s
     * @return
     */
    private int[] getNext2(char[] s) {
        // todo @jiangyuan
        return null;
    }


}
