package leetcode;

/**
 * 官方题解： 和我自己的思路是一样的：滑动窗口
 * <p>
 * 不过这个方式占用的内存更少
 */
public class Solution567_2 {
    public static void main(String[] args) {
        Solution567_2 solution = new Solution567_2();
        String s1 = "adc";
        String s2 = "dcda";

        solution.checkInclusion(s1, s2);
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[(s1.charAt(i) - 'a')]++; // 统计字符次数
            s2Count[(s2.charAt(i) - 'a')]++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (match(s1Count, s2Count)) {
                return true;
            }
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            s2Count[s2.charAt(i) - 'a']++;
        }

        return match(s1Count, s2Count);
    }

    private boolean match(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < s1Count.length; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }

}
