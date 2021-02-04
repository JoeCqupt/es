package leetcode.primary.s2_str;

import java.util.Arrays;

public class LC242 {
    public boolean isAnagram(String s, String t) {
        int[] cntA = new int[26];
        int[] cntB = new int[26];

        for (char c : s.toCharArray()) {
            cntA[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            cntB[c - 'a']++;
        }

        return Arrays.equals(cntA, cntB);
    }
}
