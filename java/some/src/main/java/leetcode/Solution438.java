package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {

    public static void main(String[] args) {

    }


    public List<Integer> findAnagrams(String s, String need) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < need.length()) {
            return result;
        }

        int[] sCount = new int[26];
        int[] needCount = new int[26];

        for (int i = 0; i < need.length(); i++) {
            needCount[need.charAt(i) - 'a']++; //  记数
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = need.length(); i < s.length(); i++) {
            if (match(sCount, needCount)) {
                result.add(i - need.length());
            }

            sCount[s.charAt(i - need.length()) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
        }

        if (match(sCount, needCount)) {
            result.add(s.length() - need.length());
        }
        return result;
    }

    private boolean match(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < s1Count.length; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }

}
